package hexlet.code.games;


import hexlet.code.Engine;

import static hexlet.code.Engine.checkCorrection;

public class GCD {

    private static int firstNumber;
    private static int secondNumber;
    private static String gcdResult;
    private static boolean check = true;

    public static void gsdGame() {
        String name = Greet.greetGame();
        System.out.println("Find the greatest common divisor of given numbers.");
        while (check) {
            firstNumber = Engine.getRandomNumber();
            secondNumber = Engine.getRandomNumber();
            gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
            System.out.println("Question: " + firstNumber + " " + secondNumber);
            check = checkCorrection(String.valueOf(gcdResult), name);
        }
    }

    public static int gcdByEuclid(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcdByEuclid(second, first % second);
    }

}
