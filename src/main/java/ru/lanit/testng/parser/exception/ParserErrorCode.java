package ru.lanit.testng.parser.exception;

/**
 * Enum of error codes for ParserException class.
 */
public enum ParserErrorCode {
    WRONG_INPUT_STRING_FORMAT("Wrong input string format"),
    WRONG_OPERAND_FORMAT("Wrong number format"),
    WRONG_OPERATOR_FORMAT("Cant recognize operator");

    private String errorMessage;

    ParserErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Return message of error code respectively.
     * @return error message.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
