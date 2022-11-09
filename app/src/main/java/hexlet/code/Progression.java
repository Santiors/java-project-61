package hexlet.code;


import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_CORRECT_ANSWERS;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;

public class Progression {

    private static Random random = new Random();
    private static boolean exit = true;
    private static Integer counter = 0;

    public static void progressionGame() {
        String name = Greet.greetGame();
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            int size = random.nextInt(RANDOM_START, RANDOM_END);
            String[] array = getProgression(size);
            int position = random.nextInt(size);
            String[] arrayWithMissing = getProgressionWithMissingElement(array, position);
            System.out.println("What number is missing in the progression?");
            printQuestionWithStringArray(arrayWithMissing);
            String answer = Engine.getAnswer();
            if (answer.equals(array[position])) {
                System.out.println("Correct!");
                counter++;
            } else if (!answer.equals(array[position])) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + array[position] + "'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            }
        }
        if (counter == NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
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
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
