package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Prime {

    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static Integer randomNumber;
    private static boolean prime;
    private static String result;

    public static void primeGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(name, arrayOfQuestions);

    }

    private static String[] generateData() {
        randomNumber = Utils.getRandomNumber();
        prime = isPrime(randomNumber);
        if (prime) {
            result = "yes";
        } else {
            result = "no";
        }
        String[] questionArray = new String[2];
        for (int i = 0; i < questionArray.length - 1; i++) {
            questionArray[i] = "Question: " + randomNumber;
            questionArray[i + 1] = result;
        }
        return questionArray;
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
