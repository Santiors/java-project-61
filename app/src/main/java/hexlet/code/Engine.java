package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_ROUNDS = 3;

    public static void checkCorrection(String description, String[][] arrayOfQuestions) {
        String answer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

        for (String[] roundData: arrayOfQuestions) {
            System.out.println("Question: " + roundData[0]);
            answer = scanner.nextLine();
            if (!answer.equals(roundData[1])) {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + roundData[1] + "'.\n"
                        + "Let's try again, " + userName + "!");
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

}
