package hexlet.code.games;


import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_VALUE_FOR_RANDOM_DATA = 100;

    public static void gsdGame() {
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(DESCRIPTION, arrayOfQuestions);
    }

    private static String[] generateData() {
        var firstNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        var secondNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        String answer = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
        var question = firstNumber + " " + secondNumber;
        return new String[] {question, answer};
    }

    private static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
