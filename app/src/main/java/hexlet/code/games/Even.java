package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static boolean even;
    private static String result;

    public static void evenGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] generateData() {
        int randomNumber = Utils.getRandomNumber();
        even = isEven(randomNumber);
        if (even) {
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



    private static boolean isEven(int number) {
        if (number % 2 != 0) {
            return false;
        }
        return true;
    }
}
