package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int RANDOM_UPPER_LIMIT = 100;
    public static final int NUMBER_OF_CORRECT_ANSWERS = 3;
    public static final int RANDOM_START = 5;
    public static final int RANDOM_END = 10;

    private static Random random = new Random();

    public static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Integer getRandomNumber() {
        return random.nextInt(1, RANDOM_UPPER_LIMIT);
    }


}
