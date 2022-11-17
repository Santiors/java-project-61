package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_VALUE_FOR_RANDOM_DATA;
import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final String DESCRIPTION = "What is the result of the expression?";

    public static void calcGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateRoundDataForCalc();
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] generateRoundDataForCalc() {
        var firstNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        var secondNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        var operation = getRandomOperation();
        var answer = String.valueOf(getResultOfOperation(firstNumber, secondNumber, operation));
        String question = firstNumber + " " + operation + " " + secondNumber;
        return new String[] {question, answer};
    }

    public static char getRandomOperation() {
        int i = Utils.generateRandomNumber(0, NUMBER_OF_OPERATIONS);
        return OPERATORS[i];
    }

    public static int getResultOfOperation(int first, int second, char oper) {
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
