package ru.lanit.testng.utils;

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

    abstract char toChar();

    public static OperatorType operatorTypeOf(char ch) {
        for (OperatorType value : OperatorType.values()) {
            if (value.toChar() == ch) {
                return value;
            }
        }
        return NONE;
    }
}