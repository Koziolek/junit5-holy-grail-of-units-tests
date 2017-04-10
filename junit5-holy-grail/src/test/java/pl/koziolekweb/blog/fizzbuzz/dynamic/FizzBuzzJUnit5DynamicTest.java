package pl.koziolekweb.blog.fizzbuzz.dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestFactory;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 *
 */
public class FizzBuzzJUnit5DynamicTest {

	private FizzBuzz sut = new FizzBuzz();

	@Nested
	class DividedBy15 {

		@TestFactory
		public Collection<DynamicTest> shouldReturnFizzBuzzIfDiv3And5() throws Exception {
			return Arrays.asList(
					dynamicTest("For 15", () -> assertEquals("FizzBuzz", sut.fizzBuzz(15))),
					dynamicTest("For 30", () -> assertEquals("FizzBuzz", sut.fizzBuzz(30))),
					dynamicTest("For 150", () -> assertEquals("FizzBuzz", sut.fizzBuzz(150)))
			);
		}
	}


	@Nested
	class DividedBy5 {

		@TestFactory
		public Stream<DynamicTest> shouldReturnBuzzIfDiv5() throws Exception {
			return Stream.of(5, 10, 50)
					.map(
							val -> dynamicTest(String.format("For %s", val)
									, () -> assertEquals("Buzz", sut.fizzBuzz(val))
							)
					);
		}
	}


	@Nested
	class DividedBy3 {

		@TestFactory
		public Iterable<DynamicTest> shouldReturnFizzIfDiv3() throws Exception {
			return Arrays.asList(
					dynamicTest("for 3", () -> assertEquals("Fizz", sut.fizzBuzz(3))),
					dynamicTest("for 6", () -> assertEquals("Fizz", sut.fizzBuzz(6))),
					dynamicTest("for 99", () -> assertEquals("Fizz", sut.fizzBuzz(99)))
			);
		}
	}

	@Nested
	class NotDividedBy3Or5 {

		@TestFactory
		public Iterator<DynamicTest> shouldReturnVal() throws Exception {
			return Arrays.asList(
					dynamicTest("for 2", () -> assertEquals("2", sut.fizzBuzz(2))),
					dynamicTest("for 9", () -> assertEquals("8", sut.fizzBuzz(8))),
					dynamicTest("for 11", () -> assertEquals("11", sut.fizzBuzz(11)))
			).iterator();
		}
	}
}