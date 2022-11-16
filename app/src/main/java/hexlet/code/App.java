package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        printHelloWindow();
        Scanner scanner = new Scanner(System.in);
        String gameType = scanner.nextLine();
        System.out.println("Your choice: " + gameType);
        switch (gameType) {
            case "1" -> Cli.greet();
            case "2" -> Even.evenGame();
            case "3" -> Calc.calcGame();
            case "4" -> GCD.gsdGame();
            case "5" -> Progression.progressionGame();
            case "6" -> Prime.primeGame();
            default -> throw new RuntimeException("Unknown operator: " + gameType);
        }
        scanner.close();
    }

    private static void printHelloWindow() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
    }

}
