package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        System.out.println("Hello, " + getName() + "!");
    }

    public static String getName() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

}
