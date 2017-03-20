package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@DisplayName("FizzBuzz should")
public class FizzBuzzJUnit5NeastedTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @Nested
    @DisplayName("return FizzBuzz when dividable by 3 and 5")
    class DividedBy15 {

        @Test
        public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
            assertEquals("FizzBuzz", sut.fizzBuzz(15));
            assertEquals("FizzBuzz", sut.fizzBuzz(30));
            assertEquals("FizzBuzz", sut.fizzBuzz(150));
        }
    }


    @Nested
    @DisplayName("return Buzz when dividable by 5")
    class DividedBy5 {
        @Test
        public void shouldReturnBuzzIfDiv5() throws Exception {
            assertEquals("Buzz", sut.fizzBuzz(5));
            assertEquals("Buzz", sut.fizzBuzz(10));
            assertEquals("Buzz", sut.fizzBuzz(50));
        }
    }


    @Nested
    @DisplayName("return Fizz when dividable by 3")
    class DividedBy3 {

        @Test
        public void shouldReturnFizzIfDiv3() throws Exception {
            assertEquals("Fizz", sut.fizzBuzz(3));
            assertEquals("Fizz", sut.fizzBuzz(6));
            assertEquals("Fizz", sut.fizzBuzz(99));
        }
    }

    @Nested
    @DisplayName("return number in other cases")
    class NotDividedBy3Or5 {

        @Test
        public void shouldReturnVal() throws Exception {
            assertEquals("2", sut.fizzBuzz(2));
            assertEquals("8", sut.fizzBuzz(8));
            assertEquals("11", sut.fizzBuzz(11));
        }
    }
}