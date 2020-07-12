package ru.lanit.testng.parser.exception;


/**
 * Exceptions for Parser class.
 */
public class ParserException extends Exception {
    private ParserErrorCode errorCode;

    public ParserException(ParserErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    /**
     * Returns exception's error code
     * @return error code
     */
    public ParserErrorCode getErrorCode() {
        return errorCode;
    }
}
