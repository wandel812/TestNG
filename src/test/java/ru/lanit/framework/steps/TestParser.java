package ru.lanit.framework.steps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.lanit.testng.parser.Parser;
import ru.lanit.testng.parser.exception.ParserException;
import ru.lanit.testng.utils.ResultTuple;

import static org.testng.Assert.*;
import static ru.lanit.testng.utils.OperatorType.*;

public class TestParser {
    @DataProvider(name = "dataProviderParsePositive")
    public Object[][] dataProviderParsePositive() {
        return new Object[][]{
                {"12.54 + 231.23", new ResultTuple(12.54, 231.23, ADDITION)},
                {"+12.54 + 231.23", new ResultTuple(12.54, 231.23, ADDITION)},
                {"12.54 + +231.23", new ResultTuple(12.54, 231.23, ADDITION)},
                {"12.54 - 231.23", new ResultTuple(12.54, 231.23, SUBTRACTION)},
                {"12.54 - -231.23", new ResultTuple(12.54, -231.23, SUBTRACTION)},
                {"12.54 * -231.23", new ResultTuple(12.54, -231.23, MULTIPLICATION)},
                {"-12.54 * -231.23", new ResultTuple(-12.54, -231.23, MULTIPLICATION)},
                {"12.54 / 231.23", new ResultTuple(12.54, 231.23, DIVISION)},
                {"124 + 0.300203", new ResultTuple(124.0, 0.300203, ADDITION)},
                {"1.20003 + 21", new ResultTuple(1.20003, 21.0, ADDITION)},
                {"1 + 2", new ResultTuple(1.0, 2.0, ADDITION)}
        };
    }

    @Test(dataProvider = "dataProviderParsePositive")
    public void testParsePositive(String input, ResultTuple expectedValue) {
        try {
            ResultTuple actualValue = Parser.parse(input);
            assertEquals(actualValue, expectedValue);
        } catch (ParserException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "dataProviderParseNegative")
    public Object[][] dataProviderParseNegative() {
        return new Object[][]{
                {"test"},
                {"teSt"},
                {"$%@!"},
                {"2134"},
                {"wD!3"},

                {"a + a"},
                {"$% f !"},
                {"- - -"},
                {"12.54 + 231.23dw"},
                {"12.54ds + 231.23"},
                {"12.54 + X231.23"},
                {"X12.54 + 231.23"},
                {"12..54 + 231.23"},
                {"12.542 + 231..23"},
                {"12.542+ + 231.23"},
                {"12.54 ++ 231.23"},
                {"12.54 + 231.23!"},
                {"12.54_ + 231.23"},

                {"12.54 + +"},
                {"2 + 3 a"},
                {"12.54+ 231.23"},
        };
    }

    @Test(dataProvider = "dataProviderParseNegative")
    public void testParseNegative(String input) {
        assertThrows(ParserException.class, () -> Parser.parse(input));
    }
}
