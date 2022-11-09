package hexlet.code;


public class Greet {

    public static String greetGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = Engine.getAnswer();
        System.out.println("Hello, " + name + "!");
        return name;
    }

}
