package hexlet.code;

import java.util.Random;

import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.games.Calc.getRandomOperation;
import static hexlet.code.games.Calc.getResultOfOperation;
import static hexlet.code.games.Even.isEven;
import static hexlet.code.games.GCD.gcdByEuclid;
import static hexlet.code.games.Prime.isPrime;
import static hexlet.code.games.Progression.getProgression;

public class Utils {

    public static final int RANDOM_UPPER_LIMIT = 100;

    private static Random random = new Random();

    public static Integer getRandomNumber() {
        return random.nextInt(1, RANDOM_UPPER_LIMIT);
    }

    public static Integer getRandomNumberInRange(int start, int end) {
        return random.nextInt(start, end);
    }

    public static Integer getRandomNumberInRangeWithoutStartPoint(int end) {
        return random.nextInt(end);
    }

    public static String[] generateData(String gameType) {
        String[] questionArray = new String[2];
        String result;
        int firstNumber;
        int secondNumber;
        int randomNumber;
        switch (gameType) {
            case "Even" -> {
                randomNumber = getRandomNumber();
                boolean even = isEven(randomNumber);
                if (even) {
                    result = "yes";
                } else {
                    result = "no";
                }
                for (int i = 0; i < questionArray.length - 1; i++) {
                    questionArray[i] = "Question: " + randomNumber;
                    questionArray[i + 1] = result;
                }
                return questionArray;
            }
            case "GCD" -> {
                firstNumber = Utils.getRandomNumber();
                secondNumber = Utils.getRandomNumber();
                String gcdResult = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
                for (int i = 0; i < questionArray.length - 1; i++) {
                    questionArray[i] = "Question: " + firstNumber + " " + secondNumber;
                    questionArray[i + 1] = gcdResult;
                }
                return questionArray;
            }
            case "Calc" -> {
                firstNumber = Utils.getRandomNumber();
                secondNumber = Utils.getRandomNumber();
                char operation = getRandomOperation();
                result = String.valueOf(getResultOfOperation(firstNumber, secondNumber, operation));
                for (int i = 0; i < questionArray.length - 1; i++) {
                    questionArray[i] = "Question: " + firstNumber + " " + operation + " " + secondNumber;
                    questionArray[i + 1] = result;
                }
                return questionArray;
            }
            case "Progression" -> {
                int size = Utils.getRandomNumberInRange(RANDOM_START, RANDOM_END);
                String[] array = getProgression(Utils.getRandomNumberInRangeWithoutStartPoint(RANDOM_END),
                        Utils.getRandomNumberInRange(1, RANDOM_END), size);
                int position = Utils.getRandomNumberInRangeWithoutStartPoint(size);
                String answer = array[position];
                array[position] = "..";
                String question = "Question: " + String.join(" ", array);
                for (int i = 0; i < questionArray.length - 1; i++) {
                    questionArray[i] = question;
                    questionArray[i + 1] = answer;
                }
                return questionArray;
            }
            case "Prime" -> {
                randomNumber = Utils.getRandomNumber();
                boolean prime = isPrime(randomNumber);
                if (prime) {
                    result = "yes";
                } else {
                    result = "no";
                }
                for (int i = 0; i < questionArray.length - 1; i++) {
                    questionArray[i] = "Question: " + randomNumber;
                    questionArray[i + 1] = result;
                }
                return questionArray;
            }
            default -> throw new RuntimeException("Unknown type: " + gameType);
        }
    }
}
