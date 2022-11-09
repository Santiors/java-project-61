package hexlet.code;

import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_CORRECT_ANSWERS;
import static hexlet.code.Engine.RANDOM_UPPER_LIMIT;

public class Even {

    private static Random random = new Random();
    private static boolean exit = true;
    private static Integer counter = 0;


    public static void evenGame() {
        String name = Greet.greetGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            Integer randomNumber = random.nextInt(RANDOM_UPPER_LIMIT);
            System.out.println("Question: " + randomNumber);
            String answer = Engine.getAnswer();
            if (((randomNumber % 2 == 0) && (answer.equals("yes")))
                    || ((randomNumber % 2 != 0) && (answer.equals("no")))) {
                System.out.println("Correct!");
                counter++;
            } else if (((randomNumber % 2 != 0) && (!answer.equals("no")))) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            } else if (((randomNumber % 2 == 0) && (!answer.equals("yes")))) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'yes'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            } else {
                exit = false;
            }
        }
        if (counter == NUMBER_OF_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

}
