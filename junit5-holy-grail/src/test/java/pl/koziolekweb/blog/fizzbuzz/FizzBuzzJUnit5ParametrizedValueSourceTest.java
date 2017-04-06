package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5ParametrizedValueSourceTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 150})
    public void shouldReturnFizzBuzzIfDiv3And5(int p) throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 50})
    public void shouldReturnBuzzIfDiv5(int p) throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 99})
    public void shouldReturnFizzIfDiv3(int p) throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 8, 11})
    public void shouldReturnVal(int p) throws Exception {
        assertEquals(p + "", sut.fizzBuzz(p));
    }
}