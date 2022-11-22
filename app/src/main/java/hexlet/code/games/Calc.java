package hexlet.code.games;


import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.checkCorrection;

public class Calc {

    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int MAX_VALUE_FOR_RANDOM_DATA = 100;

    public static void calcGame() {
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(DESCRIPTION, arrayOfQuestions);
    }

    private static String[] generateData() {
        var firstNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        var secondNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        int i = Utils.generateRandomNumber(0, OPERATORS.length - 1);
        var operation = OPERATORS[i];
        var answer = String.valueOf(getResultOfOperation(firstNumber, secondNumber, operation));
        String question = firstNumber + " " + operation + " " + secondNumber;
        return new String[] {question, answer};
    }

    private static int getResultOfOperation(int first, int second, char oper) {
        var result = 0;
        switch (oper) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            default:
                throw new RuntimeException("Unknown operation: " + oper);
        }
        return result;
    }

}
