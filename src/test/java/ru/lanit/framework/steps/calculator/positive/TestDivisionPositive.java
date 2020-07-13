package ru.lanit.framework.steps.calculator.positive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static ru.lanit.testng.Calculator.EPS;
import static ru.lanit.testng.Calculator.divide;

public class TestDivisionPositive {
    @DataProvider(name = "divisionPositive")
    public Object[][] dataProviderDivision() {
        return new Object[][]{
                {8.0, 4.0, 2.0},
                {3.33, 3.33, 1.0},
                {3.33, -3.33, -1.0},
                {-3.33, 3.33, -1.0},
                {-3.33, -3.33, 1.0},
                {3.33, 1.0, 3.33},
                {0.0, 3.23, 0.0},
                {-0.0, 3.23, 0.0},
                {0.0, -3.23, 0.0},
                {-0.0, -3.23, 0.0},
                {1.0, 1E-6, 1E6}
        };
    }

    @Test(dataProvider = "divisionPositive")
    public void testDivision(double a, double b, double result) {
        assertEquals(divide(a, b), result, EPS);
    }

}
