package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final String DESCRIPTION = "What is the result of the expression?";

    private static Integer result = 0;

    public static void calcGame() {
        char operation;
        int firstNumber;
        int secondNumber;
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                firstNumber = Utils.getRandomNumber();
                secondNumber = Utils.getRandomNumber();
                operation = getRandomOperation();
                result = getResultOfOperation(firstNumber, secondNumber, operation);
                arrayOfQuestions[i][j] = "Question: " + firstNumber + " " + operation + " " + secondNumber;
                arrayOfQuestions[i][j + 1] = String.valueOf(result);
            }
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static char getRandomOperation() {
        int i = Utils.getRandomNumberInRangeWithoutStartPoint(NUMBER_OF_OPERATIONS);
        return OPERATORS[i];
    }

    private static int getResultOfOperation(int first, int second, char oper) {
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
