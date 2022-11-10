package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.Engine.checkCorrection;

public class Progression {

    private static Random random = new Random();
    private static boolean check = true;
    private static String[] array;
    private static int position;

    public static void progressionGame() {
        String name = Greet.greetGame();
        System.out.println("What number is missing in the progression?");
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int size = random.nextInt(RANDOM_START, RANDOM_END);
                array = getProgression(size);
                position = random.nextInt(size);
                String[] arrayWithMissing = getProgressionWithMissingElement(array, position);
                arrayOfQuestions[i][j] = getQuestionWithMissingElement(arrayWithMissing);
                arrayOfQuestions[i][j + 1] = array[position];
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
    }

    public static String[] getProgression(int size) {
        String[] arr = new String[size];
        int step = random.nextInt(1, RANDOM_END);
        arr[0] = String.valueOf(random.nextInt(RANDOM_END));
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = String.valueOf(Integer.parseInt(arr[i]) + step);
        }
        return arr;
    }

    public static String[] getProgressionWithMissingElement(String[] arr, int position) {
        String[] array = arr.clone();
        array[position] = "..";
        return array;
    }

    public static String getQuestionWithMissingElement(String[] arr) {
        String questionMessage = "Question: ";
        for (int i = 0; i < arr.length; i++){
            questionMessage+= arr[i] + " ";
        }
        return questionMessage;
    }

}
