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

    public static String getGreetings() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = Engine.getAnswer();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static Integer getRandomNumber() {
        return random.nextInt(1, RANDOM_UPPER_LIMIT);
    }

    public static void getEvenGameQuestion() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static void getCalcGameQuestion() {
        System.out.println("What is the result of the expression?");
    }

    public static void getGCDGameQuestion() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static void getProgressionGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    public static void getPrimeGameQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
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
