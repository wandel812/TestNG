package ru.lanit.testng;

public class Calculator {

    public static final double EPS = 1E-7;

    public static double addition(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (Math.abs(b) <= EPS) {
            throw new ArithmeticException("division by zero");
        }
        return a / b;
    }
}
