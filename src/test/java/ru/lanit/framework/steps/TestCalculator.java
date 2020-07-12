package ru.lanit.framework.steps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static ru.lanit.testng.Calculator.*;

public class TestCalculator {
    @DataProvider(name = "addition")
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

    @Test(dataProvider = "addition")
    public void testAddition(double a, double b, double result) {
        assertEquals(addition(a, b), result, EPS);
    }

    @DataProvider(name = "subtraction")
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

    @Test(dataProvider = "subtraction")
    public void testSubtraction(double a, double b, double result) {
        assertEquals(subtraction(a, b), result, EPS);
    }

    @DataProvider(name = "multiplication")
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

    @Test(dataProvider = "multiplication")
    public void testMultiplication(double a, double b, double result) {
        assertEquals(multiplication(a, b), result, EPS);
    }

    @DataProvider(name = "division")
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

    @Test(dataProvider = "division")
    public void testDivision(double a, double b, double result) {
        assertEquals(division(a, b), result, EPS);
    }

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
        assertThrows(ArithmeticException.class, () -> division(a, b));
    }

    @DataProvider(name = "notEqualsWithAllOperators")
    public Object[][] dataProviderNotEqualsWithAllOperators() {
        return new Object[][]{
                {5.01, 2.0, 1000.01},
                {5.01, -2.0, 1000.01},
                {0.0, 3.0, 1000.01},
                {4.02, 1.0, 2000.01},
                {-4.02, 1.0, 2000.01},
                {-6.62, 1.0, 2000.01},
                {-6.62, -21.0, 2000.01}
        };
    }

    @Test(dataProvider = "notEqualsWithAllOperators")
    public void testNotEqualsWithAllOperators(double a, double b, double wrongResult) {
        assertNotEquals(addition(a, b), wrongResult);
        assertNotEquals(subtraction(a, b), wrongResult);
        assertNotEquals(multiplication(a, b), wrongResult);
        assertNotEquals(division(a, b), wrongResult);
    }


}

