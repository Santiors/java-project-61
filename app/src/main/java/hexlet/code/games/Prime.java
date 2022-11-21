package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_VALUE_FOR_RANDOM_DATA;
import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Prime {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void primeGame() {
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(DESCRIPTION, arrayOfQuestions);

    }

    private static String[] generateData() {
        var question = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
        String answer = isPrime(question) ? "yes" : "no";
        return new String[] {String.valueOf(question), answer};
    }

    private static boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
