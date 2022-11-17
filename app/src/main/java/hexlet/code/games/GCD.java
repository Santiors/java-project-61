package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.RoundDataUtils;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_VALUE_FOR_RANDOM_DATA;
import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void gsdGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = RoundDataUtils.generateData("GCD");
        }
        checkCorrection(name, arrayOfQuestions);
    }

    public static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
