package hexlet.code;

import static hexlet.code.Engine.MAX_VALUE_FOR_RANDOM_DATA;
import static hexlet.code.Engine.RANDOM_END;
import static hexlet.code.Engine.RANDOM_START;
import static hexlet.code.games.Calc.getRandomOperation;
import static hexlet.code.games.Calc.getResultOfOperation;
import static hexlet.code.games.Even.isEven;
import static hexlet.code.games.GCD.gcdByEuclid;
import static hexlet.code.games.Prime.isPrime;
import static hexlet.code.games.Progression.getProgression;

public class RoundDataUtils {

    public static String[] generateData(String gameType) {
        switch (gameType) {
            case "Even" -> {
                var question = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                String answer = isEven(question) ? "yes" : "no";
                return new String[] {String.valueOf(question), answer};
            }
            case "GCD" -> {
                var firstNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                var secondNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                String answer = String.valueOf(gcdByEuclid(firstNumber, secondNumber));
                var question = firstNumber + " " + secondNumber;
                return new String[] {question, answer};
            }
            case "Calc" -> {
                var firstNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                var secondNumber = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                var operation = getRandomOperation();
                var answer = String.valueOf(getResultOfOperation(firstNumber, secondNumber, operation));
                String question = firstNumber + " " + operation + " " + secondNumber;
                return new String[] {question, answer};
            }
            case "Progression" -> {
                var size = Utils.generateRandomNumber(RANDOM_START, RANDOM_END);
                String[] array = getProgression(Utils.generateRandomNumber(0, RANDOM_END),
                        Utils.generateRandomNumber(1, RANDOM_END), size);
                var position = Utils.generateRandomNumber(0, size - 1);
                String answer = array[position];
                array[position] = "..";
                String question = String.join(" ", array);
                return new String[] {question, answer};
            }
            case "Prime" -> {
                var question = Utils.generateRandomNumber(0, MAX_VALUE_FOR_RANDOM_DATA);
                String answer = isPrime(question) ? "yes" : "no";
                return new String[] {String.valueOf(question), answer};
            }
            default -> throw new RuntimeException("Unknown type: " + gameType);
        }
    }
}
