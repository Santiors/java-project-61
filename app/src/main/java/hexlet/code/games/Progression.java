package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.Engine.checkCorrection;

public class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static Random random = new Random();

    public static void progressionGame() {
        boolean check = true;
        String name = Engine.getGreetings(DESCRIPTION);
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int size = random.nextInt(RANDOM_START, RANDOM_END);
                String[] array = getProgression(random.nextInt(RANDOM_END), random.nextInt(1, RANDOM_END), size);
                int position = random.nextInt(size);
                String[] arrayWithMissing = getProgressionWithMissingElement(array, position);
                arrayOfQuestions[i][j] = getQuestionWithMissingElement(arrayWithMissing);
                arrayOfQuestions[i][j + 1] = array[position];
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
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
