package ru.lanit.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.testng.parser.Parser;
import ru.lanit.testng.parser.exception.ParserException;
import ru.lanit.testng.utils.ResultTuple;

import java.util.Scanner;

public class Main {
    private static final Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        System.out.println("Type \"end\" to quit the program");
        Scanner in = new Scanner(System.in);
        while (true) {
            log.info("start program cycle");
            System.out.println("Insert expression:");
            String input = in.nextLine();

            if (input.equals("end")) {
                log.info("end program cycle");
                break;
            }

            try {
                ResultTuple parsedInput;
                parsedInput = Parser.parse(input);
                System.out.println(Calculator.calculate(parsedInput));
                log.info("calculation has finished successfully");
            } catch (ParserException e) {
                System.out.println(e.getErrorCode().getErrorMessage());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
