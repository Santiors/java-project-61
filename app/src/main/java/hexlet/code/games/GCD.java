package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void gsdGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int firstNumber = Utils.getRandomNumber();
                int secondNumber = Utils.getRandomNumber();
                String gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
                arrayOfQuestions[i][j] = "Question: " + firstNumber + " " + secondNumber;
                arrayOfQuestions[i][j + 1] = gcdResult;
            }
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
