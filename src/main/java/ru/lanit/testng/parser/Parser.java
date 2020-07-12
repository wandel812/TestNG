package ru.lanit.testng.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.testng.parser.exception.ParserErrorCode;
import ru.lanit.testng.parser.exception.ParserException;
import ru.lanit.testng.utils.OperatorType;
import ru.lanit.testng.utils.ResultTuple;

/**
 * Class contains method parse which is used for extraction
 * expression elements from the console input line.
 */
public class Parser {
    private static final Logger log = LogManager.getLogger();

    /**
     * Parse console input line for expression elements.
     * @param str console input line.
     * @return tuple of left operand, right operand and operator type respectively.
     * @throws ParserException throws when console input line is incorrect.
     */
    public static ResultTuple parse(String str) throws ParserException {
        log.info("try to parse input line: [{}]", str);
        String[] values = str.split(" ");

        log.info("check that expression contains only of three elements");
        if (values.length != 3) {
            log.error("input: [{}]. Error: {}",
                    str,
                    ParserErrorCode.WRONG_INPUT_STRING_FORMAT.getErrorMessage());
            throw new ParserException(ParserErrorCode.WRONG_INPUT_STRING_FORMAT);
        }

        String numberA = values[0];
        String numberB = values[2];
        String operator = values[1];

        log.info("try to parse operands");
        double a, b;
        try {
            a = Double.parseDouble(numberA);
            b = Double.parseDouble(numberB);
        } catch (NumberFormatException ex) {
            log.error("{}. Input: a = [{}], b = [{}]]",
                    ParserErrorCode.WRONG_OPERAND_FORMAT.getErrorMessage(),
                    numberA,
                    numberB);
            throw new ParserException(ParserErrorCode.WRONG_OPERAND_FORMAT);
        }

        log.info("Check operator element should contain only char");
        if (operator.length() != 1) {
            log.error("{}, input: [{}]",
                    ParserErrorCode.WRONG_OPERATOR_FORMAT.getErrorMessage(),
                    operator);
            throw new ParserException(ParserErrorCode.WRONG_OPERATOR_FORMAT);
        }

        log.info("map operator char to enum OperatorType");
        OperatorType operatorType = OperatorType.operatorTypeOf(operator.charAt(0));
        if (operatorType.equals(OperatorType.NONE)) {
            log.error("{}. Input: {}", operator.charAt(0));
            throw new ParserException(ParserErrorCode.WRONG_OPERATOR_FORMAT);
        }

        log.info("parsing with input: [{}] has finished successfully", str);
        return new ResultTuple(a, b, operatorType);
    }
}
