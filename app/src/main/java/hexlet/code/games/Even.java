package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.RANDOM_UPPER_LIMIT;
import static hexlet.code.Engine.checkCorrection;

public class Even {

    private static Random random = new Random();
    private static boolean check = true;
    private static String result;


    public static void evenGame() {
        String name = Greet.greetGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                Integer randomNumber = random.nextInt(RANDOM_UPPER_LIMIT);
                if (randomNumber % 2 == 0) {
                    result = "yes";
                } else {
                    result = "no";
                }
                arrayOfQuestions[i][j] = "Question: " + randomNumber;
                arrayOfQuestions[i][j + 1] = result;
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
    }
}
