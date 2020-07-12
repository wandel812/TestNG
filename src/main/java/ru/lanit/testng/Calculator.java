package ru.lanit.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.testng.utils.OperatorType;
import ru.lanit.testng.utils.ResultTuple;



/**
 * This class performs main app calculations: addition, subtraction,
 * multiplication, division.
 */
public class Calculator {
    private static final Logger log = LogManager.getLogger();

    /**
     * This constant contains delta for float type comparison.
     */
    public static final double EPS = 1E-7;

    /**
     * Addition of two operands.
     * @param a left operand.
     * @param b right operand.
     * @return sum of two operands.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtraction of two operands.
     * @param a left operand.
     * @param b right operand.
     * @return subtraction of two operands.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplication of two operands.
     * @param a left operand.
     * @param b right operand.
     * @return multiplication of two operands.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Division of two operands. Whe the right operand is less or equal than
     * EPS (delta) ArithmeticException is returned.
     * @param a left operand.
     * @param b right operand.
     * @return division of two operands.
     */
    public static double divide(double a, double b) {
        if (Math.abs(b) <= EPS) {
            log.error("division by zero. Input: a = [{}], b = [{}].", a, b);
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    /**
     * Calculate the result of an two operands and operator that are
     * passed using tuple.
     * @param input tuple that contains two operands of type double
     *              and an operator through corresponding enum.
     * @return result of operands.
     */
    public static double calculate(ResultTuple input) {
       return calculate(input.operandA, input.operandB, input.operator);
    }

    /**
     * Calculate the result of two operands and operator.
     * @param a left operand.
     * @param b right operand.
     * @param operatorType operator type (addition, subtraction, etc.)
     * @return
     */
    public static double calculate(double a, double b, OperatorType operatorType) {
        switch (operatorType) {
            case ADDITION: {
                return add(a, b);
            }
            case SUBTRACTION: {
                return subtract(a, b);
            }
            case MULTIPLICATION: {
                return multiply(a, b);
            }
            case DIVISION: {
                return divide(a, b);
            }
            default: {
                log.error("Unexpected behavior. Can not calculate with operator: [{}]",
                        operatorType.toString());
                throw new RuntimeException("Should not come here!");
            }
        }
    }
}
