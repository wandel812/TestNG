package ru.lanit.framework.steps.calculator.negative;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static ru.lanit.testng.Calculator.subtract;

public class TestSubtractionNegative {
    @DataProvider(name = "subtractionNegative")
    public Object[][] dataProviderSubtractionNegative() {
        return new Object[][] {
                {4.4, 4.4, 0.000001},
                {-4.4, 4.4, -8.8888},
                {4.4, -4.4, 8.88888},
                {-2.22, -2.22, 0.000021}
        };
    }

    @Test(dataProvider = "subtractionNegative")
    public void testSubtractionNegative(double a, double b, double wrongResult) {
        assertNotEquals(subtract(a, b), wrongResult);
    }
}
