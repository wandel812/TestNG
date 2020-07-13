package ru.lanit.framework.steps.calculator.positive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static ru.lanit.testng.Calculator.EPS;
import static ru.lanit.testng.Calculator.multiply;

public class TestMultiplicationPositive {
    @DataProvider(name = "multiplicationPositive")
    public Object[][] dataProviderMultiplication() {
        return new Object[][]{
                {3.0, 2.0, 6.0},
                {5.0, 1.0, 5.0},
                {1.0, 5.0, 5.0},
                {2.0, -2.0, -4.0},
                {-4.0, 4.0, -16.0},
                {-3.0, -3.0, 9.0},
                {3.0, 0.0, 0.0},
                {0.0, 4.0, 0.0}
        };
    }

    @Test(dataProvider = "multiplicationPositive")
    public void testMultiplication(double a, double b, double result) {
        assertEquals(multiply(a, b), result, EPS);
    }
}
