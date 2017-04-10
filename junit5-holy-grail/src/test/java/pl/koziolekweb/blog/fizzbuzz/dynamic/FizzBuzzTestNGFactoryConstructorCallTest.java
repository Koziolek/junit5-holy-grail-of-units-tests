package pl.koziolekweb.blog.fizzbuzz.dynamic;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

/**
 * Created by BKuczynski on 2017-04-04.
 */
public class FizzBuzzTestNGFactoryConstructorCallTest {

	@Factory
	public Object[] fizzBuzzTestFactory() {
		FizzBuzz sut = new FizzBuzz();
		return Stream.of(
				IntStream.of(3, 6, 99).<Object>mapToObj(p -> new DividedBy3(sut, p)),
				IntStream.of(5, 10, 50).<Object>mapToObj(p -> new DividedBy5(sut, p)),
				IntStream.of(15, 30, 150).<Object>mapToObj(p -> new DividedBy15(sut, p)),
				IntStream.of(2, 8, 11).<Object>mapToObj(p -> new NotDividedBy3Or5(sut, p))
		).flatMap(Function.identity())
				.collect(Collectors.toSet()).toArray();
	}

	static class NotDividedBy3Or5 {

		private final FizzBuzz sut;
		private final int param;

		public NotDividedBy3Or5(FizzBuzz sut, int param) {
			this.sut = sut;
			this.param = param;
		}

		@Test
		public void shouldReturnVal() throws Exception {
			assertEquals(param + "", sut.fizzBuzz(param));
		}
	}

	static class DividedBy5 {


		private final FizzBuzz sut;
		private final int param;

		DividedBy5(FizzBuzz sut, int param) {
			this.sut = sut;
			this.param = param;
		}

		@Test
		public void shouldReturnBuzzIfDiv5() throws Exception {
			assertEquals("Buzz", sut.fizzBuzz(param));
		}
	}

	static class DividedBy3 {
		private final FizzBuzz sut;
		private final int param;

		DividedBy3(FizzBuzz sut, int param) {
			this.sut = sut;
			this.param = param;
		}

		@Test
		public void shouldReturnFizzIfDiv3() throws Exception {
			assertEquals("Fizz", sut.fizzBuzz(param));
		}
	}

	static class DividedBy15 {

		private final FizzBuzz sut;
		private final int param;

		DividedBy15(FizzBuzz sut, int param) {
			this.sut = sut;
			this.param = param;
		}

		@Test
		public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
			assertEquals("FizzBuzz", sut.fizzBuzz(param));
		}
	}

}
