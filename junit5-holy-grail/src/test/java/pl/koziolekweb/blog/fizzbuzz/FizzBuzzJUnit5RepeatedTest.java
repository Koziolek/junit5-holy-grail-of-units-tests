package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5RepeatedTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetition}")
    public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(15));
        assertEquals("FizzBuzz", sut.fizzBuzz(30));
        assertEquals("FizzBuzz", sut.fizzBuzz(150));
    }

    @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetition}")
    public void shouldReturnBuzzIfDiv5() throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(5));
        assertEquals("Buzz", sut.fizzBuzz(10));
        assertEquals("Buzz", sut.fizzBuzz(50));
    }

    @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetition}")
    public void shouldReturnFizzIfDiv3() throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(3));
        assertEquals("Fizz", sut.fizzBuzz(6));
        assertEquals("Fizz", sut.fizzBuzz(99));
    }

    @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetition}")
    public void shouldReturnVal() throws Exception {
        assertEquals("2", sut.fizzBuzz(2));
        assertEquals("8", sut.fizzBuzz(8));
        assertEquals("11", sut.fizzBuzz(11));
    }
}