package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@ExtendWith(IntegrationFilterExtension.class)
public class FizzBuzzJUnit5CiEnvFilteredIntegrationTest {

	private FizzBuzz sut;

	@BeforeEach
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	@Integration("CI")
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
		assertEquals("FizzBuzz", sut.fizzBuzz(30));
		assertEquals("FizzBuzz", sut.fizzBuzz(150));
	}

	@Test
	@Integration("GUI")
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertEquals("Buzz", sut.fizzBuzz(5));
		assertEquals("Buzz", sut.fizzBuzz(10));
		assertEquals("Buzz", sut.fizzBuzz(50));
	}

	@Test
	@Integration("NOGUI")
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertEquals("Fizz", sut.fizzBuzz(3));
		assertEquals("Fizz", sut.fizzBuzz(6));
		assertEquals("Fizz", sut.fizzBuzz(99));
	}

	@Test
	@Integration
	public void shouldReturnVal() throws Exception {
		assertEquals("2", sut.fizzBuzz(2));
		assertEquals("8", sut.fizzBuzz(8));
		assertEquals("11", sut.fizzBuzz(11));
	}
}
/*

W poprzednim wpisie zajmowaliśmy się standardowymi implementacjami <samp>ParameterResolver</samp>. Na zakończenie wspomniałem, że własna implementacja wymaga konfiguracji na poziomie silnika testów. Takie podejście jest uciążliwe i wiąże się m.in. z implementacją własnego silnika lub hackowaniem istniejącego. To jest trochę krzywe. Twórcy biblioteki JUnit 5 mając świadomość, że takie rozwiązanie jest kiepskie, przygotowali mechanizm rozszerzeń.

Rozszerzenia można z grubsza podzielić na dwie grupy. Pierwsza to rozszerzenia deklaratywne. Tym przyjrzymy się dzisiaj. Druga to rozszerzenia oparte o mechanizm SPI. W tym przypadku wykorzystujemy rejestr serwisów, a rozszerzenia są rejestrowane w momencie startu kontenera. Przykładem tego typu rozszerzenia jest <samp>junit-jupiter-params</samp>, z którym mieliśmy już do czynienia. Tym mechanizmem zajmiemy się później (znacznie później, jak go rozkminię ;) ).

<h4>Problem</h4>

Zanim przejdę do opisu mechanizmu rozszerzeń, to pozwolę sobie na zdefiniowanie problemu, który będzie stanowić tło naszych rozważań. Mamy pewną ilość testów integracyjnych, z których część może być uruchomiona tylko i wyłącznie na określonych maszynach w ramach CI. Maszyna identyfikuje się za pomocą zmiennej systemowej. Ponadto, chcemy by testy te, można było uruchomić na maszynie deweloperskiej oznaczonej jako <em>DEV</em>. Programiści nie muszą nic konfigurować na swoich maszynach.

Inaczej mówiąc, jeżeli jest obecna zmienna środowiskowa <samp>ci_name</samp>, to test będzie uruchomiony, jeżeli jej wartość odpowiada wartości z adnotacji. Jeżeli nie jest definiowana albo jest równa <samp>DEV</samp>, to test też jest uruchamiany.

<h4>Rozwiązanie</h4>

Zacznę trochę od dupy strony, czyli od przygotowania mechanizmu, który będzie odpowiadać za oznaczanie testów do uruchomienia. W tym celu należy zaimplementować interfejs <samp>TestExecutionCondition</samp>. Ma on jedną metodę, <samp>evaluate</samp>, która przyjmuje <samp>TestExtensionContext</samp> i zwraca <samp>ConditionEvaluationResult</samp>. Kod wygląda następująco:

<p class="listing">Listing 1. Implementacja <samp>TestExecutionCondition</samp></p>
<pre class="java" name="code">public class IntegrationFilterExtension implements TestExecutionCondition {

    private static final String CI_NAME = Optional.ofNullable(
            System.getenv("ci_name")
    )
            .orElse("DEV");

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return context.getTestMethod()
                .filter(m -> isAnnotated(m, Integration.class))
                .map(m -> m.getAnnotation(Integration.class).value())
                .filter(((Predicate<String>) s -> CI_NAME.equals(s)).or(s1 -> CI_NAME.equals("DEV")))
                .map($ -> ConditionEvaluationResult.enabled(""))
                .orElse(ConditionEvaluationResult.disabled(format("This test %s cannot be run on %s.", context.getTestMethod().map(Method::getName).get(), CI_NAME)));
    }

}</pre>

Przeszukujemy metody oznaczone adnotacją <samp>@Integration</samp>:

<p class="listing">Listing 2. Adnotacja <samp>@Integration</samp></p>
<pre class="java" name="code">@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Integration {

    String value() default "DEV";
}
</pre>

Jeżeli wartość w adnotacji jest inna niż zadeklarowana w zmiennej <samp>ci_name</samp>, to zwracamy <samp>ConditionEvaluationResult.disabled</samp> z odpowiednim komunikatem.

Interfejs <samp>TestExecutionCondition</samp> jest jednym z kilku, które możemy wykorzystać. Zanim jednak przejdę do omówienia innych interfejsów, chciałbym pokazać, jak uruchamiamy nasze rozszerzenie.

<h5>Uruchomienie rozszerzenia</h5>

Jak wspomniałem na samym początku, w tym wpisie zajmiemy się rozszerzeniami deklaratywnymi. Deklaratywność oznacza tu, że musimy w kodzie explicite wskazać których rozszerzeń używamy. Można pomyśleć o tym mechanizmie jak o runnerach. Różnica polega na tym, że w JUnit 5 możemy użyć wielu rozszerzeń dla jednej klasy testowej.

By uruchomić test z rozszerzeniem należy użyć adnotacji <samp>@ExtendWith</samp>.

<p class="listing">Listing 3. Przykładowy test z rozszerzeniem</p>
<pre class="java" name="code">@ExtendWith(IntegrationFilterExtension.class)
public class FizzBuzzJUnit5CiEnvFilteredIntegrationTest {

	private FizzBuzz sut;

	@BeforeEach
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	@Integration("CI")
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
	}

	@Test
	@Integration("GUI")
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertEquals("Buzz", sut.fizzBuzz(5));
	}

	@Test
	@Integration("NOGUI")
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertEquals("Fizz", sut.fizzBuzz(3));
	}

	@Test
	@Integration
	public void shouldReturnVal() throws Exception {
		assertEquals("2", sut.fizzBuzz(2));
	}
}</pre>

Mamy tu cztery testy integracyjne, z których każdy może zostać uruchomiony tylko na konkretnych środowiskach CI. Przy czym ostatni z nich, <samp>shouldReturnVal</samp>, może zostać uruchomiony jedynie na środowisku deweloperskim.

Jak można zauważyć ten mechanizm, nie jest jakoś skomplikowany. Jego zaletą jest prostota implementacji oraz jasność intencji. Dla tego konkretnego przypadku konfiguracja tagów mogłaby być wystarczająca, ale wymagałaby wdrożenia profili. Profile są specyficzne dla mavena i trudno nimi zarządzać z poziomu poma. Złożoność będzie szybko rosła wraz ze wzrostem liczby środowisk. W dodatku użycie filtrów opartych o tagi albo nazwy metod uniemożliwia raportowanie przyczyny wyłączenia testu.

<h4>Inne punkty rozszerzeń</h4>

Oczywiście rozszerzenia to nie tylko decydowanie o uruchomieniu bądź nie testu. Ciekawym przypadkiem może być wprowadzenie własnej implementacji <samp>ParameterResolver</samp>.

<h5>Własny <samp>ParameterResolver</samp></h5>

Załóżmy, że nasz test potrzebuje pewnych informacji ze świata. Możemy podać je na kilka sposobów. Najprościej jest stworzyć odpowiedniego mocka i przekazać go jakoś do testu. Jakoś w naszym przypadku oznacza parametr metody testowej. 
 */