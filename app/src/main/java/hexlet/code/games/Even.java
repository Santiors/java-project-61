package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_VALUE_FOR_RANDOM_DATA = 100;

    public static void evenGame() {
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(DESCRIPTION, arrayOfQuestions);
    }

    private static String[] generateData() {
        var question = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        String answer = isEven(question) ? "yes" : "no";
        return new String[] {String.valueOf(question), answer};
    }

    private static boolean isEven(int number) {
        if (number % 2 != 0) {
            return false;
        }
        return true;
    }
}
