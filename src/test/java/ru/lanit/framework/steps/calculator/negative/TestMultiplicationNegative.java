package ru.lanit.framework.steps.calculator.negative;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static ru.lanit.testng.Calculator.multiply;

public class TestMultiplicationNegative {
    @DataProvider(name = "multiplicationNegative")
    public Object[][] dataProviderMultiplicationNegative() {
        return new Object[][] {
                {4.0, 0.0, 1.0},
                {0.0, 22.2, 0.01},
                {1.0, 2.2, 2.3},
                {-1.0, -1.0, -1.0},
                {-2.0, 2.0, 4.0},
                {3.3, -1.0, 3.3}
        };
    }

    @Test(dataProvider = "multiplicationNegative")
    public void testMultiplicationNegative(double a, double b, double wrongResult) {
        assertNotEquals(multiply(a, b), wrongResult);
    }
}
