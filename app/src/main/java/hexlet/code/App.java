package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit");
        Integer gameType = getGameNumber();
        System.out.println("Your choice: " + gameType);
        switch (gameType) {
            case 1:
                Greet.greetGame();
                break;
            case 2:
                Even.evenGame();
                break;
            default:
                break;
        }
    }

    public static Integer getGameNumber() {
        Scanner sc = new Scanner(System.in);
        Integer answer = sc.nextInt();
        return answer;
    }

}
