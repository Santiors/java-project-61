package hexlet.code;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Even.NUMBER_OF_CORRECT_ANSWERS;
import static hexlet.code.Even.RANDOM_UPPER_LIMIT;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;

    private static Random random = new Random();
    private static boolean exit = true;
    private static Integer counter = 0;
    private static Integer firstNumber;
    private static Integer secondNumber;
    private static Integer result = 0;
    private static Integer answer;
    private static String operation;

    public static void calcGame() {
        String name = Greet.greetGame();
        System.out.println("What is the result of the expression?");
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            firstNumber = getRandomNumber();
            secondNumber = getRandomNumber();
            operation = getRandomOperation();
            switch (operation) {
                case " + ":
                    result = firstNumber + secondNumber;
                    break;
                case " - ":
                    result = firstNumber - secondNumber;
                    break;
                case " * ":
                    result = firstNumber * secondNumber;
                    break;
                default:
                    break;
            }
            System.out.println("Question: " + firstNumber + operation + secondNumber);
            answer = getAnswer();
            if (answer.equals(result)) {
                System.out.println("Correct!");
                counter++;
            } else if (!answer.equals(result)) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + result + "'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            }
        }
        if (counter == NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static String getRandomOperation() {
        String[] operations = {" + ", " - ", " * "};
        int i = random.nextInt(NUMBER_OF_OPERATIONS);
        return operations[i];
    }

    public static Integer getRandomNumber() {
        return random.nextInt(RANDOM_UPPER_LIMIT);
    }

    public static Integer getAnswer() {
        Scanner sc = new Scanner(System.in);
        Integer answer = sc.nextInt();
        return answer;
    }
}
