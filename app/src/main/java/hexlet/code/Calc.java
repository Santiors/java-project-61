package hexlet.code;


import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_CORRECT_ANSWERS;
import static hexlet.code.Engine.RANDOM_UPPER_LIMIT;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;

    private static Integer firstNumber;
    private static Integer secondNumber;
    private static Integer result = 0;
    private static String answer;
    private static String operation;
    private static Random random = new Random();
    private static boolean exit = true;
    private static Integer counter = 0;

    public static void calcGame() {
        String name = Greet.greetGame();
        System.out.println("What is the result of the expression?");
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            firstNumber = Engine.getRandomNumber();
            secondNumber = Engine.getRandomNumber();
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
            answer = Engine.getAnswer();
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

}
