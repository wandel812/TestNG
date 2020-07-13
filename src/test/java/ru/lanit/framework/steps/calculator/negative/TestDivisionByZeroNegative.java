package ru.lanit.framework.steps.calculator.negative;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static ru.lanit.testng.Calculator.divide;

public class TestDivisionByZeroNegative {
    @DataProvider(name = "divisionByZero")
    public Object[][] dataProviderDivisionByZer() {
        return new Object[][]{
                {1.0, 0.0},
                {1.0, 1E-7},
                {1.0, 1E-8},
                {1.0, -1E-8},
                {-1.0, 1E-8},
                {-1.0, -1E-8},
        };
    }

    @Test(dataProvider = "divisionByZero")
    public void testDivisionByZero(double a, double b) {
        assertThrows(ArithmeticException.class, () -> divide(a, b));
    }
}
