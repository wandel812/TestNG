package ru.lanit.testng.utils;

import java.util.Objects;

public class ResultTuple<T, S, U> {
    public final T operandA;
    public final S operandB;
    public final U operator;

    public ResultTuple(T operandA, S operandB, U operator) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "(" + operandA +
                ", " + operandB +
                ", " + operator +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultTuple<?, ?, ?> that = (ResultTuple<?, ?, ?>) o;
        return operandA.equals(that.operandA)
                && operandB.equals(that.operandB)
                && operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operandA, operandB, operator);
    }
}
