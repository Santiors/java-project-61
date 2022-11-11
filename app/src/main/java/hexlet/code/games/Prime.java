package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;
import static hexlet.code.Engine.getRandomNumber;

public class Prime {

    private static String result;
    private static boolean check = true;
    private static Integer randomNumber;

    public static void primeGame() {
        String name = Engine.getGreetings();
        Engine.getPrimeGameQuestion();
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                randomNumber = getRandomNumber();
                result = getAnswerResultOfIsPrime(randomNumber);
                arrayOfQuestions[i][j] = "Question: " + randomNumber;
                arrayOfQuestions[i][j + 1] = result;
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }

    }

    private static String getAnswerResultOfIsPrime(Integer number) {
        boolean isPrime = isPrime(number);
        if (isPrime) {
            return "yes";
        } else {
            return "no";
        }
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
