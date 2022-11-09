package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.RANDOM_UPPER_LIMIT;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static Random random = new Random();
    private static boolean check = true;
    private static String result;


    public static void evenGame() {
        String name = Greet.greetGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (check) {
            Integer randomNumber = random.nextInt(RANDOM_UPPER_LIMIT);
            System.out.println("Question: " + randomNumber);
            if (randomNumber % 2 == 0) {
                result = "yes";
            } else {
                result = "no";
            }
            check = checkCorrection(result, name);
        }
    }
}
