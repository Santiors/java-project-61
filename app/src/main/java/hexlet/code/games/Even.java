package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundDataUtils;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_VALUE_FOR_RANDOM_DATA;
import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void evenGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = RoundDataUtils.generateData("Even");
        }
        checkCorrection(name, arrayOfQuestions);
    }

    public static boolean isEven(int number) {
        if (number % 2 != 0) {
            return false;
        }
        return true;
    }
}
