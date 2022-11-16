package hexlet.code;

import java.util.Random;

public class Utils {

    private static Random random = new Random();
    public static final int RANDOM_UPPER_LIMIT = 100;

    public static Integer getRandomNumber() {
        return random.nextInt(1, RANDOM_UPPER_LIMIT);
    }

    public static Integer getRandomNumberInRange(int start, int end) {
        return random.nextInt(start, end);
    }

    public static Integer getRandomNumberInRangeWithoutStartPoint(int end) {
        return random.nextInt(end);
    }
}
