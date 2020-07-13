package ru.lanit.framework.steps.calculator.positive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static ru.lanit.testng.Calculator.EPS;
import static ru.lanit.testng.Calculator.add;

public class TestAdditionPositive {
    @DataProvider(name = "additionPositive")
    public Object[][] dataProviderAddition() {
        return new Object[][]{
                {5.0, 4.0, 9.0},
                {-5.0, 4.0, -1.0},
                {4.0, -5.0, -1.0},
                {-4.0, -5.0, -9.0},
                {-5.3, 4.1, -1.2},
                {4.3, -5.2, -0.9},
                {4.0, 0.0, 4.0},
                {0.0, 4.0, 4.0},
                {2.0, 3.33, 5.33}
        };
    }

    @Test(dataProvider = "additionPositive")
    public void testAddition(double a, double b, double result) {
        assertEquals(add(a, b), result, EPS);
    }
}
