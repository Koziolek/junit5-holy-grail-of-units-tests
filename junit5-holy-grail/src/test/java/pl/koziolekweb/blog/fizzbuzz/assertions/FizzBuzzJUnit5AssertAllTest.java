package pl.koziolekweb.blog.fizzbuzz.assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5AssertAllTest {

	private FizzBuzz sut;

	@BeforeEach
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertAll(
				() -> assertEquals("FizzBuzz", sut.fizzBuzz(15)),
				() -> assertEquals("FizzBuzz", sut.fizzBuzz(30)),
				() -> assertEquals("FizzBuzz", sut.fizzBuzz(150))
		);
	}

	@Test
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertAll(
				() -> assertEquals("Buzz", sut.fizzBuzz(5)),
				() -> assertEquals("Buzz", sut.fizzBuzz(10)),
				() -> assertEquals("Buzz", sut.fizzBuzz(50))
		);

	}

	@Test
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertAll(
				() -> assertEquals("Fizz", sut.fizzBuzz(3)),
				() -> assertEquals("Fizz", sut.fizzBuzz(6)),
				() -> assertEquals("Fizz", sut.fizzBuzz(99))
		);
	}

	@Test
	public void shouldReturnVal() throws Exception {
		assertAll(
				() -> assertEquals("2", sut.fizzBuzz(2)),
				() -> assertEquals("8", sut.fizzBuzz(8)),
				() -> assertEquals("11", sut.fizzBuzz(11))
		);
	}
}