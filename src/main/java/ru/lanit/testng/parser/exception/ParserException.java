package ru.lanit.testng.parser.exception;

public class ParserException extends Exception {
    private ParserErrorCode errorCode;

    public ParserException(ParserErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ParserErrorCode getErrorCode() {
        return errorCode;
    }
}
