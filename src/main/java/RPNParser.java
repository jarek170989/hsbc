import exceptions.WrongInputException;
import input.CommandLineRPNInputFetcher;
import input.RPNInputFetcher;
import output.PrintOnCommandLineRPNOutput;
import output.RPNOutput;

import java.util.*;

public class RPNParser {

    static RPNInputFetcher rpnInputFetcher;
    static RPNOutput rpnOutput;
    static Set<String> availableArithmeticalOperations = new HashSet<>(Arrays.asList("+","-"));
    static final String WRONG_NUMBER_OF_NUMBERS_MESSAGE = "There is a wrong number of numbers in passed argument!";
    static final String ILLEGAL_TYPE_OF_NUMBER_MESSAGE = "Wrong data as argument! You need to put only digits or available " +
            "arithmetical operations signs splitted by space.";

    public static void main(String[] args) {
        rpnInputFetcher = new CommandLineRPNInputFetcher(args[0]);
        String rpnString = rpnInputFetcher.getRPN();
        try {
            Stack<String> stackOfElements = proceedWithRPNAlgorithm(rpnString);
            rpnOutput = new PrintOnCommandLineRPNOutput(stackOfElements.pop());
            rpnOutput.outputRPNValue();
        } catch (IllegalArgumentException | WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Stack<String> proceedWithRPNAlgorithm(String rpnString) {
        String[] arrayOfElementsFromRPNString = rpnString.split(" ");
        Stack<String> stackOfElements = new Stack<>();
        for(String str : arrayOfElementsFromRPNString) {
            if (!availableArithmeticalOperations.contains(str)) {
                checkIfNumber(str);
                stackOfElements.push(str);
            } else {
                if (stackOfElements.size() < 2) {
                    throw new WrongInputException(WRONG_NUMBER_OF_NUMBERS_MESSAGE);
                }
                String firstEl = stackOfElements.pop();
                String secondEl = stackOfElements.pop();
                switch (str) {
                    case "+":
                        stackOfElements.push(String.valueOf(Integer.parseInt(secondEl)+Integer.parseInt(firstEl)));
                        break;
                    case "-":
                        stackOfElements.push(String.valueOf(Integer.parseInt(secondEl)-Integer.parseInt(firstEl)));
                        break;
                }
            }
        };
        if (stackOfElements.size() != 1) {
            throw new WrongInputException(WRONG_NUMBER_OF_NUMBERS_MESSAGE);
        }
        return stackOfElements;
    }

    private static void checkIfNumber(String str) {
        if (!str.matches("[0-9]+")) {
            throw new IllegalArgumentException(ILLEGAL_TYPE_OF_NUMBER_MESSAGE);
        }
    }
}
