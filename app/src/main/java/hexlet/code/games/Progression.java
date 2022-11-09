package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.Engine.checkCorrection;

public class Progression {

    private static Random random = new Random();
    private static boolean check = true;

    public static void progressionGame() {
        String name = Greet.greetGame();
        while (check) {
            int size = random.nextInt(RANDOM_START, RANDOM_END);
            String[] array = getProgression(size);
            int position = random.nextInt(size);
            String[] arrayWithMissing = getProgressionWithMissingElement(array, position);
            System.out.println("What number is missing in the progression?");
            printQuestionWithStringArray(arrayWithMissing);
            check = checkCorrection(array[position], name);
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

    public static void printQuestionWithStringArray(String[] array) {
        System.out.print("Question: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
