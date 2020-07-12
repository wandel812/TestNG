package ru.lanit.testng;

import ru.lanit.testng.parser.Parser;
import ru.lanit.testng.parser.exception.ParserException;
import ru.lanit.testng.utils.OperatorType;
import ru.lanit.testng.utils.ResultTuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type \"end\" to quit the program");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Insert expression:");
            String input = in.nextLine();

            if (input.equals("end")) {
                break;
            }

            try {
                ResultTuple parsedInput;
                parsedInput = Parser.parse(input);
                System.out.println(Calculator.calculate(parsedInput));
            } catch (ParserException e) {
                System.out.println(e.getErrorCode().getErrorMessage());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
