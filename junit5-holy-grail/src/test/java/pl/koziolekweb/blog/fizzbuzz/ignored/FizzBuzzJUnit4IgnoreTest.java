package pl.koziolekweb.blog.fizzbuzz.ignored;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@Ignore
public class FizzBuzzJUnit4IgnoreTest {

	private FizzBuzz sut;

	@Before
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
		assertEquals("FizzBuzz", sut.fizzBuzz(30));
		assertEquals("FizzBuzz", sut.fizzBuzz(150));
	}

	@Test
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertEquals("Buzz", sut.fizzBuzz(5));
		assertEquals("Buzz", sut.fizzBuzz(10));
		assertEquals("Buzz", sut.fizzBuzz(50));
	}

	@Test
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertEquals("Fizz", sut.fizzBuzz(3));
		assertEquals("Fizz", sut.fizzBuzz(6));
		assertEquals("Fizz", sut.fizzBuzz(99));
	}

	@Test
	public void shouldReturnVal() throws Exception {
		assertEquals("2", sut.fizzBuzz(2));
		assertEquals("8", sut.fizzBuzz(8));
		assertEquals("11", sut.fizzBuzz(11));
	}
}