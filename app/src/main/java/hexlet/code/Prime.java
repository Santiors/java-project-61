package hexlet.code;

import static hexlet.code.Engine.NUMBER_OF_CORRECT_ANSWERS;
import static hexlet.code.Engine.getAnswer;
import static hexlet.code.Engine.getRandomNumber;

public class Prime {

    private static String answer;
    private static String result;
    private static boolean exit = true;
    private static Integer counter = 0;

    public static void primeGame() {
        String name = Greet.greetGame();
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            Integer randomNumber = getRandomNumber();
            System.out.println("Question: " + randomNumber);
            answer = getAnswer();
            result = checkIsPrime(randomNumber);
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

    private static String checkIsPrime(Integer number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
