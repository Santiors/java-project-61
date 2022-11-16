package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static int firstNumber;
    private static int secondNumber;

    public static void gsdGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] generateData() {
        firstNumber = Utils.getRandomNumber();
        secondNumber = Utils.getRandomNumber();
        String gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
        String[] questionArray = new String[2];
        for (int i = 0; i < questionArray.length - 1; i++) {
            questionArray[i] = "Question: " + firstNumber + " " + secondNumber;
            questionArray[i + 1] = gcdResult;
        }
        return questionArray;
    }

    private static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
