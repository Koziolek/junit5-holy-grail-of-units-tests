package pl.koziolekweb.blog.fizzbuzz.parametrized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5ParametrizedConvertersTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @ParameterizedTest
    @ValueSource(strings = {"f", "1E", "96"})
    public void shouldReturnFizzBuzzIfDiv3And5(@ConvertWith(HexToInt.class) int p) throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "a", "32"})
    public void shouldReturnBuzzIfDiv5(@ConvertWith(HexToInt.class) int p) throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "6", "63"})
    public void shouldReturnFizzIfDiv3(@ConvertWith(HexToInt.class) int p) throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "8", "B"})
    public void shouldReturnVal(@ConvertWith(HexToInt.class) int p) throws Exception {
        assertEquals(p + "", sut.fizzBuzz(p));
    }

    static class HexToInt extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> targetType) {
            assertEquals(int.class, targetType, "Can only convert to int");
            return Integer.decode("0x" + o.toString());
        }
    }
}