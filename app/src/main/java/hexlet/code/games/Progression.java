package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.Engine.checkCorrection;

public class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static void progressionGame() {
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int size = Utils.getRandomNumberInRange(RANDOM_START, RANDOM_END);
                String[] array = getProgression(Utils.getRandomNumberInRangeWithoutStartPoint(RANDOM_END),
                        Utils.getRandomNumberInRange(1, RANDOM_END), size);
                int position = Utils.getRandomNumberInRangeWithoutStartPoint(size);
                String[] arrayWithMissing = getProgressionWithMissingElement(array, position);
                arrayOfQuestions[i][j] = getQuestionWithMissingElement(arrayWithMissing);
                arrayOfQuestions[i][j + 1] = array[position];
            }
        }
        checkCorrection(name, arrayOfQuestions);
    }

    private static String[] getProgression(int first, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i += 1) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

    private static String[] getProgressionWithMissingElement(String[] arr, int elementPosition) {
        String[] arrayWithMissing = arr.clone();
        arrayWithMissing[elementPosition] = "..";
        return arrayWithMissing;
    }

    private static String getQuestionWithMissingElement(String[] arr) {
        String questionMessage = "Question: ";
        for (int i = 0; i < arr.length; i++) {
            questionMessage += arr[i] + " ";
        }
        return questionMessage;
    }

}
