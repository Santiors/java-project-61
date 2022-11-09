package hexlet.code;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Even.NUMBER_OF_CORRECT_ANSWERS;

public class GCD {

    private static Random random = new Random();
    private static boolean exit = true;
    private static Integer counter = 0;
    private static int firstNumber;
    private static int secondNumber;
    private static int gcdResult;
    private static String answer;

    public static void gsdGame() {
        String name = Greet.greetGame();
        System.out.println("Find the greatest common divisor of given numbers.");
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            firstNumber = Calc.getRandomNumber();
            secondNumber = Calc.getRandomNumber();
            gcdResult = gcdByEuclid(firstNumber, secondNumber);
            System.out.println("Question: " + firstNumber + " " + secondNumber);
            answer = getAnswer();
            if (answer.equals(gcdResult)) {
                System.out.println("Correct!");
                counter++;
            } else if (!answer.equals(gcdResult)) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + gcdResult + "'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            }
        }
        if (counter == NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

    public static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
