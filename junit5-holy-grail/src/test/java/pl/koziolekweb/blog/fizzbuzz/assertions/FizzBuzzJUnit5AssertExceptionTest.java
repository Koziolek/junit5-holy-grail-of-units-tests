package pl.koziolekweb.blog.fizzbuzz.assertions;

import org.junit.jupiter.api.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 */
public class FizzBuzzJUnit5AssertExceptionTest {

	private FizzBuzz sut;

	@Test
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertThrows(NullPointerException.class, () -> assertEquals("FizzBuzz", sut.fizzBuzz(15)));
		assertThrows(NullPointerException.class, () -> assertEquals("FizzBuzz", sut.fizzBuzz(30)));
		assertThrows(NullPointerException.class, () -> assertEquals("FizzBuzz", sut.fizzBuzz(150)));
	}

	@Test
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertThrows(NullPointerException.class, () -> assertEquals("Buzz", sut.fizzBuzz(5)));
		assertThrows(NullPointerException.class, () -> assertEquals("Buzz", sut.fizzBuzz(10)));
		assertThrows(NullPointerException.class, () -> assertEquals("Buzz", sut.fizzBuzz(50)));
	}

	@Test
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertThrows(NullPointerException.class, () -> assertEquals("Fizz", sut.fizzBuzz(3)));
		assertThrows(NullPointerException.class, () -> assertEquals("Fizz", sut.fizzBuzz(6)));
		assertThrows(NullPointerException.class, () -> assertEquals("Fizz", sut.fizzBuzz(99)));
	}

	@Test
	public void shouldReturnVal() throws Exception {
		assertThrows(NullPointerException.class, () -> assertEquals("2", sut.fizzBuzz(2)));
		assertThrows(NullPointerException.class, () -> assertEquals("8", sut.fizzBuzz(8)));
		assertThrows(NullPointerException.class, () -> assertEquals("11", sut.fizzBuzz(11)));
	}
}