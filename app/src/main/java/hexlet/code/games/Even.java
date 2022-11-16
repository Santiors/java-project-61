package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void evenGame() {
        boolean even;
        String result;
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int randomNumber = Utils.getRandomNumber();
                even = isEven(randomNumber);
                if (even) {
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

    private static boolean isEven(int number) {
        if (number % 2 != 0) {
            return false;
        }
        return true;
    }
}
