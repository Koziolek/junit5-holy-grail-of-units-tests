package pl.koziolekweb.blog.fizzbuzz.assertions;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.blog.fizzbuzz.FizzBuzz;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class FizzBuzzJUnit5AssumeTest {

    private FizzBuzz sut;

    @BeforeEach
    public void setup() {
        sut = new FizzBuzz();
    }

    @Test
    public void shouldReturnFizzBuzzIfDiv3And5() throws Exception {
        Assumptions.assumeTrue(getEnvAssumption("CI"), "Not on CI or DEV");
        assertEquals("FizzBuzz", sut.fizzBuzz(15));
    }

    @Test
    public void shouldReturnBuzzIfDiv5() throws Exception {
        Assumptions.assumeTrue(getEnvAssumption("GUI"), "Not on GUI or DEV");
        assertEquals("Buzz", sut.fizzBuzz(5));
    }

    @Test
    public void shouldReturnFizzIfDiv3() throws Exception {
        Assumptions.assumeTrue(getEnvAssumption("NOGUI"), "Not on NOGUI or DEV");
        assertEquals("Fizz", sut.fizzBuzz(3));
    }

    @Test
    public void shouldReturnVal() throws Exception {
        Assumptions.assumeTrue(getEnvAssumption("NOGUI"), "Not on NOGUI or DEV");
        assertEquals("2", sut.fizzBuzz(2));
    }

    private BooleanSupplier getEnvAssumption(String isIt) {
        return () -> {
            String envName = Optional.ofNullable(System.getenv("ci_name")).orElse("DEV");
            return Optional.of(envName).map(s -> s.equals(isIt) || s.equals("DEV")).get();
        };
    }
}