package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int MAX_VALUE_FOR_RANDOM_DATA = 100;
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final int RANDOM_START = 5;
    public static final int RANDOM_END = 10;
    public static final int NUMBER_OF_ROWS = 3;
    public static final int NUMBER_OF_COLUMNS = 2;

    private static Random random = new Random();
    private static Integer counter = 0;
    private static boolean check = true;
    private static String answer;

    public static String getGreetings(String description) {
        String userName = Cli.greet();
        System.out.println(description);
        return userName;
    }

    public static void checkCorrection(String name, String[][] arrayOfQuestions) {
        Scanner sc = new Scanner(System.in);

        while (counter < NUMBER_OF_ROUNDS && check) {
            System.out.println("Question: " + arrayOfQuestions[counter][0]);
            answer = sc.nextLine();
            if (!answer.equals(arrayOfQuestions[counter][1])) {
                check = false;
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + arrayOfQuestions[counter][1] + "'.\n"
                        + "Let's try again, " + name + "!");
            } else {
                System.out.println("Correct!");
                counter++;
            }
        }
        if (counter == NUMBER_OF_ROUNDS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

}
