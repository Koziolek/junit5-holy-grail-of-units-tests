package pl.koziolekweb.blog.fizzbuzz;

import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

/**
 * Created by BKuczynski on 2017-04-04.
 */
public class FizzBuzzTestNGParametrizedTest {

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

    @Test(dataProvider = "3 and 5")
    public void shouldReturnFizzBuzzIfDiv3And5(int p) throws Exception {
        assertEquals("FizzBuzz", sut.fizzBuzz(p));
    }

    @Test(dataProvider = "5 only")
    public void shouldReturnBuzzIfDiv5(int p) throws Exception {
        assertEquals("Buzz", sut.fizzBuzz(p));
    }

    @Test(dataProvider = "3 only")
    public void shouldReturnFizzIfDiv3(int p) throws Exception {
        assertEquals("Fizz", sut.fizzBuzz(p));
    }

    @Test(dataProvider = "other values")
    public void shouldReturnVal(int p) throws Exception {
        assertEquals(p + "", sut.fizzBuzz(p));
    }

    @DataProvider(name = "3 and 5")
    public Object[][] data3And5() {
        return new Object[][]{
                new Object[]{15},
                new Object[]{30},
                new Object[]{150}
        };
    }

    @DataProvider(name = "3 only")
    public Object[][] data3Only() {
        return new Object[][]{
                new Object[]{3},
                new Object[]{6},
                new Object[]{99}
        };
    }

    @DataProvider(name = "5 only")
    public Object[][] data5Only() {
        return new Object[][]{
                new Object[]{5},
                new Object[]{10},
                new Object[]{50}
        };
    }

    @DataProvider(name = "other values")
    public Object[][] dataOtherValues() {
        return new Object[][]{
                new Object[]{2},
                new Object[]{8},
                new Object[]{11}
        };
    }
}
