package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Prime {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static Integer randomNumber;

    public static void primeGame() {
        boolean prime;
        String result;
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                randomNumber = Utils.getRandomNumber();
                prime = isPrime(randomNumber);
                if (prime) {
                    result = "yes";
                } else {
                    result = "no";
                }
                arrayOfQuestions[i][j] = "Question: " + randomNumber;
                arrayOfQuestions[i][j + 1] = result;
            }
        }
        checkCorrection(name, arrayOfQuestions);

    }

    private static boolean isPrime(Integer number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
