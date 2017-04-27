package pl.koziolekweb.blog.fizzbuzz.nested;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
@DisplayName("FizzBuzz should")
public class FizzBuzzJUnit5NestedTest {

	private FizzBuzz sut;

	@BeforeEach
	public void setup() {
		sut = new FizzBuzz();
	}

	@Nested
	@DisplayName("return FizzBuzz")
	class DividedBy15 {

		@Test
		@DisplayName("when dividable by 3 and 5: ")
		public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
			assertEquals("FizzBuzz", sut.fizzBuzz(15));
			assertEquals("FizzBuzz", sut.fizzBuzz(30));
			assertEquals("FizzBuzz", sut.fizzBuzz(150));
		}
	}


	@Nested
	@DisplayName("return Buzz")
	class DividedBy5 {

		@Test
		@DisplayName("when dividable by 5")
		public void shouldReturnBuzzIfDiv5() throws Exception {
			assertEquals("Buzz", sut.fizzBuzz(5));
			assertEquals("Buzz", sut.fizzBuzz(10));
			assertEquals("Buzz", sut.fizzBuzz(50));
		}
	}


	@Nested
	@DisplayName("return Fizz")
	class DividedBy3 {

		@Test
		@DisplayName("when dividable by 3")
		public void shouldReturnFizzIfDiv3() throws Exception {
			assertEquals("Fizz", sut.fizzBuzz(3));
			assertEquals("Fizz", sut.fizzBuzz(6));
			assertEquals("Fizz", sut.fizzBuzz(99));
		}
	}

	@Nested
	@DisplayName("return number")
	class NotDividedBy3Or5 {

		@Test
		@DisplayName("in other cases")
		public void shouldReturnVal() throws Exception {
			assertEquals("2", sut.fizzBuzz(2));
			assertEquals("8", sut.fizzBuzz(8));
			assertEquals("11", sut.fizzBuzz(11));
		}
	}
}