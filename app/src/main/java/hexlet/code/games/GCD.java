package hexlet.code.games;


import hexlet.code.Engine;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static int firstNumber;
    private static int secondNumber;
    private static String gcdResult;
    private static boolean check = true;

    public static void gsdGame() {
        String name = Greet.greetGame();
        System.out.println("Find the greatest common divisor of given numbers.");
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                firstNumber = Engine.getRandomNumber();
                secondNumber = Engine.getRandomNumber();
                gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
                arrayOfQuestions[i][j] = "Question: " + firstNumber + " " + secondNumber;
                arrayOfQuestions[i][j + 1] = gcdResult;
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
    }

    public static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
