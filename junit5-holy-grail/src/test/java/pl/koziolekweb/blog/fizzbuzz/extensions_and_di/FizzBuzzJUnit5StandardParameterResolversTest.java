package pl.koziolekweb.blog.fizzbuzz.extensions_and_di;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5StandardParameterResolversTest {

	private FizzBuzz sut;

	@BeforeAll
	static void classSetup(TestInfo testInfo) {
		Logger.getLogger("JUnit 5").info(
				String
						.format("Test from %s started at %s",
								testInfo.getTestClass().map(Class::getName).get(),
								LocalDateTime.now()
						)
		);
	}

	@AfterAll
	static void classTeardown(TestInfo testInfo) {
		Logger.getLogger("JUnit 5").info(
				String
						.format("Test from %s finished at %s",
								testInfo.getTestClass().map(Class::getName).get(),
								LocalDateTime.now()
						)
		);
	}

	@BeforeEach
	public void setup(TestInfo testInfo) {
		Logger.getLogger("JUnit 5").info(
				String
						.format("Test %s from %s started at %s",
								testInfo.getDisplayName(),
								testInfo.getTestMethod().map(Method::getName).get(),
								LocalDateTime.now()
						)
		);
		sut = new FizzBuzz();
	}

	@AfterEach
	public void tearDown(TestInfo testInfo) {
		sut = null;
		Logger.getLogger("JUnit 5").info(
				String
						.format("Test %s from %s finished at %s",
								testInfo.getDisplayName(),
								testInfo.getTestMethod().map(Method::getName).get(),
								LocalDateTime.now()
						)
		);
	}

	@RepeatedTest(10)
	public void shouldReturnFizzBuzzIfDiv3And5(RepetitionInfo repetitionInfo, TestInfo testInfo) throws Exception {
		Logger.getLogger("JUnit 5").info(
				String
						.format("Running %s %s of %s",
								testInfo.getTestMethod().map(Method::getName).get(),
								repetitionInfo.getCurrentRepetition(),
								repetitionInfo.getTotalRepetitions()
						)
		);
		assertEquals("FizzBuzz", sut.fizzBuzz(15));
		assertEquals("FizzBuzz", sut.fizzBuzz(30));
		assertEquals("FizzBuzz", sut.fizzBuzz(150));
	}

	@Test
	public void shouldReturnBuzzIfDiv5(TestReporter testReporter) throws Exception {
		testReporter.publishEntry("Do this stuff", "too often");
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