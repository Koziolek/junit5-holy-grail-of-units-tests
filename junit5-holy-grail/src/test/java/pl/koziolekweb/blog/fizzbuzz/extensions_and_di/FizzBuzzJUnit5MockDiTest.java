package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 *
 */
@ExtendWith(MockParameterResolver.class)
@ExtendWith(MockFieldInjector.class)
public class FizzBuzzJUnit5MockDiTest {

	@Mock
	private FizzBuzz sut;

	@Test
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		when(sut.fizzBuzz(anyInt())).then(invocation -> "FizzBuzz");
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
		assertEquals("FizzBuzz", sut.fizzBuzz(30));
		assertEquals("FizzBuzz", sut.fizzBuzz(150));
	}

	@Test
	public void shouldReturnBuzzIfDiv5(@Mock FizzBuzz sut) throws Exception {
		when(sut.fizzBuzz(anyInt())).then(invocation -> "Buzz");
		assertEquals("Buzz", sut.fizzBuzz(5));
		assertEquals("Buzz", sut.fizzBuzz(10));
		assertEquals("Buzz", sut.fizzBuzz(50));
	}

	@Test
	public void shouldReturnFizzIfDiv3(@Mock FizzBuzz sut) throws Exception {
		when(sut.fizzBuzz(anyInt())).then(invocation -> "Fizz");
		assertEquals("Fizz", sut.fizzBuzz(3));
		assertEquals("Fizz", sut.fizzBuzz(6));
		assertEquals("Fizz", sut.fizzBuzz(99));
	}

	@Test
	public void shouldReturnVal(@Mock FizzBuzz sut) throws Exception {
		when(sut.fizzBuzz(anyInt())).then(invocation -> invocation.getArgument(0).toString());
		assertEquals("2", sut.fizzBuzz(2));
		assertEquals("8", sut.fizzBuzz(8));
		assertEquals("11", sut.fizzBuzz(11));
	}
}