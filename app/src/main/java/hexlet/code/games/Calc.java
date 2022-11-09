package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.checkCorrection;

public class Calc {

    private static final int NUMBER_OF_OPERATIONS = 3;

    private static Integer firstNumber;
    private static Integer secondNumber;
    private static Integer result = 0;
    private static String operation;
    private static Random random = new Random();
    private static boolean check = true;

    public static void calcGame() {
        String name = Greet.greetGame();
        System.out.println("What is the result of the expression?");
        while (check) {
            firstNumber = Engine.getRandomNumber();
            secondNumber = Engine.getRandomNumber();
            operation = getRandomOperation();
            switch (operation) {
                case " + ":
                    result = firstNumber + secondNumber;
                    break;
                case " - ":
                    result = firstNumber - secondNumber;
                    break;
                case " * ":
                    result = firstNumber * secondNumber;
                    break;
                default:
                    break;
            }
            System.out.println("Question: " + firstNumber + operation + secondNumber);
            check = checkCorrection(String.valueOf(result), name);
        }
    }

    public static String getRandomOperation() {
        String[] operations = {" + ", " - ", " * "};
        int i = random.nextInt(NUMBER_OF_OPERATIONS);
        return operations[i];
    }

}
