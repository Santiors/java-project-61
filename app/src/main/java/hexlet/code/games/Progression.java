package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROUNDS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.Engine.checkCorrection;

public class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static void progressionGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            arrayOfQuestions[i] = generateRoundDataForProgression();
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] generateRoundDataForProgression() {
        var size = Utils.generateRandomNumber(RANDOM_START, RANDOM_END);
        String[] array = getProgression(Utils.generateRandomNumber(0, RANDOM_END),
                Utils.generateRandomNumber(1, RANDOM_END), size);
        var position = Utils.generateRandomNumber(0, size - 1);
        String answer = array[position];
        array[position] = "..";
        String question = String.join(" ", array);
        return new String[] {question, answer};
    }

    public static String[] getProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

}
