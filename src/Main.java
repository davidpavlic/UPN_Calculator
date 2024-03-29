
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Write your calculation in UPN:");
        List<Character> inputList = retrieveInput();
        System.out.println("[1] to activate stepmode");
        String stepmode = scanner.next();

        if(UPNValidator.validate(new LinkedList<>(inputList))){
            if(stepmode.equals("1"))
                System.out.println(UPNCalculator.calculateSteps(new LinkedList<>(inputList)));
            else
                System.out.println(UPNCalculator.calculate(new LinkedList<>(inputList)));
        }
        else
            System.out.println("Is Invalid");
    }

    private static List<Character> retrieveInput(){
        List<Character> inputList = new LinkedList<>();
        char[] inputChars = scanner.next().toCharArray();

        for (char c : inputChars) {
            inputList.add(c);
        }
        return inputList;
    }

}