package ru.lanit.testng.utils;

/**
 * Enum that contains set of operators.
 */
public enum OperatorType {
    ADDITION {
        @Override
        char toChar() {
            return '+';
        }
    },
    SUBTRACTION {
        @Override
        char toChar() {
            return '-';
        }
    },
    MULTIPLICATION {
        @Override
        char toChar() {
            return '*';
        }
    },
    DIVISION {
        @Override
        char toChar() {
            return '/';
        }
    },
    NONE {
        @Override
        char toChar() {
            return 'n';
        }
    };

    /**
     * Map enum element to char.
     * @return a char that represents its enum.
     */
    abstract char toChar();

    /**
     * Map char to enum element.
     * @param ch a char that represents its enum.
     * @return OperatorType corresponding to the char
     * or NONE OperatorType otherwise.
     */
    public static OperatorType operatorTypeOf(char ch) {
        for (OperatorType value : OperatorType.values()) {
            if (value.toChar() == ch) {
                return value;
            }
        }
        return NONE;
    }
}