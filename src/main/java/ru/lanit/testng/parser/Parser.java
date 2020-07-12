package ru.lanit.testng.parser;

import ru.lanit.testng.parser.exception.ParserErrorCode;
import ru.lanit.testng.parser.exception.ParserException;
import ru.lanit.testng.utils.OperatorType;
import ru.lanit.testng.utils.ResultTuple;

public class Parser {
    public static ResultTuple parse(String str) throws ParserException {
        String[] values = str.split(" ");

        if (values.length != 3) {
            throw new ParserException(ParserErrorCode.WRONG_INPUT_STRING_FORMAT);
        }

        String numberA = values[0];
        String numberB = values[2];
        String operator = values[1];

        double a, b;
        try {
            a = Double.parseDouble(numberA);
            b = Double.parseDouble(numberB);
        } catch (NumberFormatException ex) {
            throw new ParserException(ParserErrorCode.WRONG_OPERAND_FORMAT);
        }

        if (values[1].length() != 1) {
            throw new ParserException(ParserErrorCode.WRONG_OPERATOR_FORMAT);
        }
        OperatorType operatorType = OperatorType.operatorTypeOf(operator.charAt(0));
        if (operatorType.equals(OperatorType.NONE)) {
            throw new ParserException(ParserErrorCode.WRONG_OPERATOR_FORMAT);
        }

        return new ResultTuple(a, b, operatorType);
    }
}
