package ru.lanit.framework.steps.calculator.positive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static ru.lanit.testng.Calculator.EPS;
import static ru.lanit.testng.Calculator.subtract;

public class TestSubtractionPositive {
    @DataProvider(name = "subtractionPositive")
    public Object[][] dataProviderSubtraction() {
        return new Object[][]{
                {5.0, 3.0, 2.0},
                {5.3, 3.2, 2.1},
                {3.0, 5.0, -2.0},
                {3.2, 5.3, -2.1},
                {2, 0.0, 2.0},
                {0.0, 2.0, -2.0},
                {6.0, 6.0, 0.0},
                {-2.0, -2.0, 0.0}
        };
    }

    @Test(dataProvider = "subtractionPositive")
    public void testSubtraction(double a, double b, double result) {
        assertEquals(subtract(a, b), result, EPS);
    }

}
