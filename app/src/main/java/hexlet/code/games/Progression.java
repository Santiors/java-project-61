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
            arrayOfQuestions[i] = generateData();
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] generateData() {
        int size = Utils.getRandomNumberInRange(RANDOM_START, RANDOM_END);
        String[] array = getProgression(Utils.getRandomNumberInRangeWithoutStartPoint(RANDOM_END),
                Utils.getRandomNumberInRange(1, RANDOM_END), size);
        int position = Utils.getRandomNumberInRangeWithoutStartPoint(size);
        String answer = array[position];
        array[position] = "..";
        String question = "Question: " + String.join(" ", array);
        String[] questionArray = new String[2];
        for (int i = 0; i < questionArray.length - 1; i++) {
            questionArray[i] = question;
            questionArray[i + 1] = answer;
        }
        return questionArray;
    }

    private static String[] getProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

}
