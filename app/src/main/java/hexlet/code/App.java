package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        printHelloWindow();
        String gameType = getGameType();
        System.out.println("Your choice: " + gameType);
        switch (gameType) {
            case "1":
                Greet.greetGame();
                break;
            case "2":
                Even.evenGame();
                break;
            case "3":
                Calc.calcGame();
                break;
            case "4":
                GCD.gsdGame();
                break;
            case "5":
                Progression.progressionGame();
                break;
            case "6":
                Prime.primeGame();
                break;
            default:
                throw new RuntimeException("Unknown operator: " + gameType);
        }
    }

    private static void printHelloWindow() {
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit");
    }

    private static String getGameType() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
