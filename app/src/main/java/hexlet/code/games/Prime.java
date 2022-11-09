package hexlet.code.games;

import static hexlet.code.Engine.checkCorrection;
import static hexlet.code.Engine.getRandomNumber;

public class Prime {

    private static String result;
    private static boolean check = true;

    public static void primeGame() {
        String name = Greet.greetGame();
        while (check) {
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            Integer randomNumber = getRandomNumber();
            System.out.println("Question: " + randomNumber);
            result = checkIsPrime(randomNumber);
            check = checkCorrection(result, name);
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
