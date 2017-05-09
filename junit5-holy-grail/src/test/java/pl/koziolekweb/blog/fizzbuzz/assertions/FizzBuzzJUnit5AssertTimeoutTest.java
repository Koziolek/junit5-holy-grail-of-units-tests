package pl.koziolekweb.blog.fizzbuzz.assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 *
 */
public class FizzBuzzJUnit5AssertTimeoutTest {

	private FizzBuzz sut;

	@BeforeEach
	public void setup() {
		sut = new FizzBuzz();
	}

	@Test
	public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
		assertAll(
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("FizzBuzz", sut.fizzBuzz(15));
					Thread.sleep(200);
				}),
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("FizzBuzz", sut.fizzBuzz(30));
					Thread.sleep(200);
				}),
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("FizzBuzz", sut.fizzBuzz(150));
					Thread.sleep(200);
				})
		);
	}

	@Test
	public void shouldReturnBuzzIfDiv5() throws Exception {
		assertAll(
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("Buzz", sut.fizzBuzz(5));
					Thread.sleep(200);
				}, "Ups... out of time!"),
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("Buzz", sut.fizzBuzz(10));
					Thread.sleep(200);
				}, "Ups... out of time!"),
				() -> assertTimeout(Duration.ofMillis(100), () -> {
					assertEquals("Buzz", sut.fizzBuzz(50));
					Thread.sleep(200);
				}, "Ups... out of time!")
		);
	}

	@Test
	public void shouldReturnFizzIfDiv3() throws Exception {
		assertAll(
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("Fizz", sut.fizzBuzz(3));
					Thread.sleep(200);
				}),
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("Fizz", sut.fizzBuzz(6));
					Thread.sleep(200);
				}),
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("Fizz", sut.fizzBuzz(99));
					Thread.sleep(200);
				})
		);
	}

	@Test
	public void shouldReturnVal() throws Exception {
		assertAll(
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("2", sut.fizzBuzz(2));
					Thread.sleep(200);
				}, "Ups... out of time!"),
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("8", sut.fizzBuzz(8));
					Thread.sleep(200);
				}, "Ups... out of time!"),
				() -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
					assertEquals("11", sut.fizzBuzz(11));
					Thread.sleep(200);
				}, "Ups... out of time!")
		);
	}
}