package hexlet.code;

import java.util.Scanner;

public class Greet {

    public static String greetGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = getName();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static String getName() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
}
