package pl.koziolekweb.blog.fizzbuzz;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5Test {

	private FizzBuzz sut;

	@BeforeAll
	static void classSetup() {
		Logger.getLogger("JUnit 4").info("Started at " + LocalDateTime.now());
	}

	@AfterAll
	static void classTeardown() {
		Logger.getLogger("JUnit 4").info("Finished at " + LocalDateTime.now());
	}

	@BeforeEach
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