package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5ParametrizedArgumentSourceTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @ParameterizedTest
    @ArgumentsSource(Data3And5.class)
    public void shouldReturnFizzBuzzIfDiv3And5(int p) throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ArgumentsSource(Data5Only.class)
    public void shouldReturnBuzzIfDiv5(int p) throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ArgumentsSource(Data3Only.class)
    public void shouldReturnFizzIfDiv3(int p) throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ArgumentsSource(DataOtherValues.class)
    public void shouldReturnVal(int p) throws Exception {
        assertEquals(p + "", sut.fizzBuzz(p));
    }

    static class Data3And5 implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) throws Exception {
            return Stream.of(15, 30, 150).map(ObjectArrayArguments::create);
        }
    }

    static class Data3Only implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) throws Exception {
            return Stream.of(3, 6, 99).map(ObjectArrayArguments::create);
        }
    }

    static class Data5Only implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) throws Exception {
            return Stream.of(5, 10, 50).map(ObjectArrayArguments::create);
        }
    }

    static class DataOtherValues implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) throws Exception {
            return Stream.of(2, 8, 11).map(ObjectArrayArguments::create);
        }
    }
}