package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int RANDOM_UPPER_LIMIT = 100;
    public static final int NUMBER_OF_CORRECT_ANSWERS = 3;
    public static final int RANDOM_START = 5;
    public static final int RANDOM_END = 10;
    public static final int NUMBER_OF_ROWS = 3;
    public static final int NUMBER_OF_COLUMNS = 2;

    private static Random random = new Random();
    private static Integer counter = 0;
    private static boolean check = true;
    private static String answer;

    public static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getGreetings(String description) {
        String userName = Cli.greet();
        System.out.println(description);
        return userName;
    }

    public static Integer getRandomNumber() {
        return random.nextInt(1, RANDOM_UPPER_LIMIT);
    }

    public static boolean checkCorrection(String name, String[][] arrayOfQuestions) {
        while (counter < NUMBER_OF_CORRECT_ANSWERS && check) {
            System.out.println(arrayOfQuestions[counter][0]);
            answer = Engine.getAnswer();
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
        if (counter == NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
            return false;
        }
        return check;
    }

}
