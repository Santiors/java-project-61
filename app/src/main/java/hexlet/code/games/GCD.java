package hexlet.code.games;


import hexlet.code.Engine;

import static hexlet.code.Engine.NUMBER_OF_COLUMNS;
import static hexlet.code.Engine.NUMBER_OF_ROWS;
import static hexlet.code.Engine.checkCorrection;

public class GCD {

    public static void gsdGame() {
        boolean check = true;
        String name = Engine.getGreetings();
        Engine.getGCDGameQuestion();
        String[][] arrayOfQuestions = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < arrayOfQuestions.length; i++) {
            for (int j = 0; j < arrayOfQuestions[i].length - 1; j++) {
                int firstNumber = Engine.getRandomNumber();
                int secondNumber = Engine.getRandomNumber();
                String gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
                arrayOfQuestions[i][j] = "Question: " + firstNumber + " " + secondNumber;
                arrayOfQuestions[i][j + 1] = gcdResult;
            }
        }
        while (check) {
            check = checkCorrection(name, arrayOfQuestions);
        }
    }

    private static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
