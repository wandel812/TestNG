package ru.lanit.testng;

import ru.lanit.testng.utils.OperatorType;
import ru.lanit.testng.utils.ResultTuple;

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

    public static double calculate(ResultTuple input) {
       return calculate(input.operandA, input.operandB, input.operator);
    }

    public static double calculate(double a, double b, OperatorType operatorType) {
        switch (operatorType) {
            case ADDITION: {
                return addition(a, b);
            }
            case SUBTRACTION: {
                return subtraction(a, b);
            }
            case MULTIPLICATION: {
                return multiplication(a, b);
            }
            case DIVISION: {
                return division(a, b);
            }
            default: {
                throw new RuntimeException("Should not come here!");
            }
        }
    }
}
