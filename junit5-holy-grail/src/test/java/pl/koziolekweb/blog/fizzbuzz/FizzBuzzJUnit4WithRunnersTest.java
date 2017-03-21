package pl.koziolekweb.blog.fizzbuzz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(JUnitParamsRunner.class)
public class FizzBuzzJUnit4WithRunnersTest {

	private FizzBuzz sut;

	@Before
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	@Parameters(value = {"15", "30", "150"})
	public void shouldReturnFizzBuzzIfDiv3And5(int p) throws Exception {
		assertEquals("FizzBuzz", sut.fizzBuzz(p));
	}

	@Test
	@Parameters(value = {"5", "10", "50"})
	public void shouldReturnBuzzIfDiv5(int p) throws Exception {
		assertEquals("Buzz", sut.fizzBuzz(p));
	}

	@Test
	@Parameters(value = {"3", "6", "99"})
	public void shouldReturnFizzIfDiv3(int p) throws Exception {
		assertEquals("Fizz", sut.fizzBuzz(p));
	}


	@Test
	@Parameters(value = {"2", "8", "11"})
	public void shouldReturnVal(int p) throws Exception {
		assertEquals("" + p, sut.fizzBuzz(p));
	}
}