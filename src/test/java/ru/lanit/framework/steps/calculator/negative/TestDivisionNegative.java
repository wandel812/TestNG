package ru.lanit.framework.steps.calculator.negative;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static ru.lanit.testng.Calculator.divide;

public class TestDivisionNegative {
    @DataProvider(name = "divisionNegative")
    public Object[][] dataProviderNotEqualsWithAllOperators() {
        return new Object[][]{
                {53.2, 0.001, 1000000.0},
                {0.0, 2.22, 0.0001},
                {34.2, 1.0, 34.3},
                {32.2, -1.0, 32.2},
                {-4.02, 1.0, 4.02},
                {-6.62, -1.0, -6.62},
                {9.0, 3.0, 2.0}
        };
    }

    @Test(dataProvider = "divisionNegative")
    public void testDivisionNegative(double a, double b, double wrongResult) {
        assertNotEquals(divide(a, b), wrongResult);
    }
}
