package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static final int RANDOM_UPPER_LIMIT = 1000;
    private static final int NUMBER_OF_CORRECT_ANSWERS = 3;


    public static void evenGame() {
        String name = Greet.greetGame();
        boolean exit = true;
        Integer counter = 0;
        Random random = new Random();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (exit && counter < NUMBER_OF_CORRECT_ANSWERS) {
            Integer randomNumber = random.nextInt(RANDOM_UPPER_LIMIT);
            System.out.println("Question: " + randomNumber);
            String answer = getAnswer();
            if (((randomNumber % 2 == 0) && (answer.equals("yes")))
                    || ((randomNumber % 2 != 0) && (answer.equals("no")))) {
                System.out.println("Correct!");
                counter++;
            } else if (((randomNumber % 2 != 0) && (!answer.equals("yes")))) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, " + name + "!");
                exit = false;
            } else if (((randomNumber % 2 == 0) && (!answer.equals("no")))) {
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

    public static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer;
    }
}
