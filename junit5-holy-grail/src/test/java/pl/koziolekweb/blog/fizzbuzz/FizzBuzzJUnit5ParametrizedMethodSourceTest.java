package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5ParametrizedMethodSourceTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @ParameterizedTest
    @MethodSource(names = "data3And5")
    public void shouldReturnFizzBuzzIfDiv3And5(int p) throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @MethodSource(names = "data5Only")
    public void shouldReturnBuzzIfDiv5(int p) throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @MethodSource(names = "data3Only")
    public void shouldReturnFizzIfDiv3(int p) throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(p));
    }

    @ParameterizedTest
    @MethodSource(names = "dataOtherValues")
    public void shouldReturnVal(int p) throws Exception {
        assertEquals(p + "", sut.fizzBuzz(p));
    }

    static Stream data3And5() {
        return Stream.of(15, 30, 150);
    }

    static Stream data3Only() {
        return Stream.of(3, 6, 99);
    }

    static Stream data5Only() {
        return Stream.of(5, 10, 50);
    }

    static Stream dataOtherValues() {
        return Stream.of(2, 8, 11);
    }
}