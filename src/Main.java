
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final UPNCalculator upnCalculator = new UPNCalculator();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        // Read UPN input from user
        System.out.println("Write your calculation in UPN:");
        List<Character> inputList = retrieveInput();

        // Validate User Input
        if (upnCalculator.validate(new LinkedList<>(inputList))) {
            System.out.println("UPN expression is valid");
        } else {
            System.out.println("Invalid UPN expression");
            return;
        }

        // Ask user which mode to use
        System.out.println("Please choose a mode:");
        System.out.println("[1] to activate Step Mode");
        System.out.println("[2] to activate Run Mode");
        String stepMode = scanner.next();


        if (stepMode.equals("1"))
            try {
                System.out.println(upnCalculator.calculateSteps(new LinkedList<>(inputList)));
            } catch (IllegalArgumentException e) {
                System.out.println("There was an issue trying to calculate the Steps of the UPN Expression: " + e.getMessage());
            }
        else if (stepMode.equals("2")) {
            try {
                System.out.println(upnCalculator.calculate(new LinkedList<>(inputList)));
            } catch (IllegalArgumentException e) {
                System.out.println("There was an issue trying to calculate the UPN Expression: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid mode");
        }

    }

    private List<Character> retrieveInput() {
        List<Character> inputList = new LinkedList<>();
        char[] inputChars = scanner.nextLine().trim().replace(" ", "").toCharArray();

        for (char c : inputChars) {
            inputList.add(c);
        }
        return inputList;
    }

}