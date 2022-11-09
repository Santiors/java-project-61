package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int RANDOM_UPPER_LIMIT = 100;
    public static final int NUMBER_OF_CORRECT_ANSWERS = 3;
    public static final int RANDOM_START = 5;
    public static final int RANDOM_END = 10;

    public static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


}
