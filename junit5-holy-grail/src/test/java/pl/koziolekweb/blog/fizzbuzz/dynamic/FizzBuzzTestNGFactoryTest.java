package pl.koziolekweb.blog.fizzbuzz.dynamic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.testng.Assert.assertEquals;

/**
 * Created by BKuczynski on 2017-04-04.
 */
public class FizzBuzzTestNGFactoryTest {

	@Factory
	public Object[] fizzBuzzTestFactory() {
		return new Object[]{new DividedBy3(),new DividedBy5(), new DividedBy15(), new NotDividedBy3Or5()};
	}

	static class NotDividedBy3Or5 {

		private FizzBuzz sut;

		@BeforeTest
		public void setup() {
			sut = new FizzBuzz();
		}

		@Test
		public void shouldReturnVal() throws Exception {
			assertEquals("2", sut.fizzBuzz(2));
			assertEquals("8", sut.fizzBuzz(8));
			assertEquals("11", sut.fizzBuzz(11));
		}
	}

	static class DividedBy5 {

		private FizzBuzz sut;

		@BeforeTest
		public void setup() {
			sut = new FizzBuzz();
		}

		@Test
		public void shouldReturnBuzzIfDiv5() throws Exception {
			assertEquals("Buzz", sut.fizzBuzz(5));
			assertEquals("Buzz", sut.fizzBuzz(10));
			assertEquals("Buzz", sut.fizzBuzz(50));
		}
	}

	static class DividedBy3 {
		private FizzBuzz sut;

		@BeforeTest
		public void setup() {
			sut = new FizzBuzz();
		}

		@Test
		public void shouldReturnFizzIfDiv3() throws Exception {
			assertEquals("Fizz", sut.fizzBuzz(3));
			assertEquals("Fizz", sut.fizzBuzz(6));
			assertEquals("Fizz", sut.fizzBuzz(99));
		}
	}

	static class DividedBy15 {

		private FizzBuzz sut;

		@BeforeTest
		public void setup() {
			sut = new FizzBuzz();
		}

		@Test
		public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
			assertEquals("FizzBuzz", sut.fizzBuzz(15));
			assertEquals("FizzBuzz", sut.fizzBuzz(30));
			assertEquals("FizzBuzz", sut.fizzBuzz(150));
		}
	}

}
