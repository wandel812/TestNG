package ru.lanit.framework.steps.calculator.negative;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static ru.lanit.testng.Calculator.add;

public class TestAdditionNegative {
    @DataProvider(name = "additionNegative")
    public Object[][] dataProviderAdditionNegative() {
        return new Object[][]{
                {5.02, 2.0, 7.02001},
                {-3.33, -3.33, 6.66},
                {-2.2, 2.2, 0.000001},
                {0.0, -2.0, 2.00}
        };
    }

    @Test(dataProvider = "additionNegative")
    public void testAdditionNegative(double a, double b, double wrongResult) {
        assertNotEquals(add(a, b), wrongResult);
    }
}
