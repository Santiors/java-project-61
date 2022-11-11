package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;

    private static Integer firstNumber;
    private static Integer secondNumber;
    private static Integer result = 0;
    private static String operation;
    private static Random random = new Random();
    private static boolean check = true;

    public static void calcGame() {
        String name = Engine.getGreetings();
        Engine.getCalcGameQuestion();
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                firstNumber = Engine.getRandomNumber();
                secondNumber = Engine.getRandomNumber();
                operation = getRandomOperation();
                result = getResultOfOperation(firstNumber, secondNumber, operation);
                arrayOfQuestions[i][j] = "Question: " + firstNumber + operation + secondNumber;
                arrayOfQuestions[i][j + 1] = String.valueOf(result);
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
    }

    private static String getRandomOperation() {
        String[] operations = {" + ", " - ", " * "};
        int i = random.nextInt(NUMBER_OF_OPERATIONS);
        return operations[i];
    }

    private static int getResultOfOperation(int first, int second, String oper) {
        switch (oper) {
            case " + ":
                result = first + second;
                break;
            case " - ":
                result = first - second;
                break;
            case " * ":
                result = first * second;
                break;
            default:
                throw new RuntimeException("Unknown operation: " + oper);
        }
        return result;
    }

}
