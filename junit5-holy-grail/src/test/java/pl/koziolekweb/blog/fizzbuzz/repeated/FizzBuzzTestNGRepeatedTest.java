package pl.koziolekweb.blog.fizzbuzz.repeated;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

/**
 * Created by BKuczynski on 2017-04-04.
 */
@Test
public class FizzBuzzTestNGRepeatedTest {

	private FizzBuzz sut;

	@BeforeClass
	static void classSetup() {
		Logger.getLogger("TestNG").info("Started at " + LocalDateTime.now());
	}

	@AfterClass
	static void classTeardown() {
		Logger.getLogger("TestNG").info("Finished at " + LocalDateTime.now());
	}

	@BeforeTest
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test(invocationCount = 100, threadPoolSize = 4)
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
		assertEquals("FizzBuzz", sut.fizzBuzz(30));
		assertEquals("FizzBuzz", sut.fizzBuzz(150));
	}

	@Test(invocationCount = 100, threadPoolSize = 4)
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertEquals("Buzz", sut.fizzBuzz(5));
		assertEquals("Buzz", sut.fizzBuzz(10));
		assertEquals("Buzz", sut.fizzBuzz(50));
	}

	@Test(invocationCount = 100, threadPoolSize = 4)
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertEquals("Fizz", sut.fizzBuzz(3));
		assertEquals("Fizz", sut.fizzBuzz(6));
		assertEquals("Fizz", sut.fizzBuzz(99));
	}

	@Test(invocationCount = 100, threadPoolSize = 4)
	public void shouldReturnVal() throws Exception {
		assertEquals("2", sut.fizzBuzz(2));
		assertEquals("8", sut.fizzBuzz(8));
		assertEquals("11", sut.fizzBuzz(11));
	}

}
