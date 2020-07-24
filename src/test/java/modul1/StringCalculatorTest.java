package modul1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeAll
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void shouldReturn0WhenNullGiven() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    void shouldReturn0WhenZeroGiven() {
        assertEquals(0, calculator.add("0"));
    }

    @Test
    void shouldReturn0WhenLetterGiven() {
        assertEquals(0, calculator.add("A"));
    }

    @Test
    void shouldReturnNegativeNumberWhenNegativeNuberGiven() {
        assertEquals(-1, calculator.add("-1"));
    }

    @Test
    void shouldReturnCorrectSum() {
        assertEquals(3, calculator.add("2,1"));
        assertEquals(3, calculator.add("3"));
    }

    @Test
    void shouldReturnCorrectSumWithNegativeNumbersGive() {
        assertEquals(-1, calculator.add("-2,1"));
        assertEquals(-33, calculator.add("-33"));
    }
}
