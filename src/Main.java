
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final UPNCalculator upnCalculator = new UPNCalculator();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run(){
        System.out.println("Write your calculation in UPN:");
        List<Character> inputList = retrieveInput();
        System.out.println("[1] to activate stepmode");
        String stepmode = scanner.next();

        if(upnCalculator.validate(new LinkedList<>(inputList))){
            if(stepmode.equals("1"))
                System.out.println(upnCalculator.calculateSteps(new LinkedList<>(inputList)));
            else
                System.out.println(upnCalculator.calculate(new LinkedList<>(inputList)));
        }
        else
            System.out.println("Is Invalid");
    }

    private List<Character> retrieveInput(){
        List<Character> inputList = new LinkedList<>();
        char[] inputChars = scanner.nextLine().trim().toCharArray();

        for (char c : inputChars) {
            inputList.add(c);
        }
        return inputList;
    }

}