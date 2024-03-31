import MyCollections.MyStack;

import java.util.List;

public class UPNCalculator {

    public static int calculate(List<Character> characterList) {
        MyStack upnStack = new MyStack();
        for (char character : characterList) {
            processCharacter(character, upnStack);
        }
        if (upnStack.size() != 1) {
            throw new IllegalArgumentException("Invalid UPN expression");
        }
        return upnStack.pop();
    }

    public static int calculateSteps(List<Character> characterList){
        MyStack upnStack = new MyStack();
        for (char character : characterList) {
            System.out.println("Characters to read: " + characterList);
            System.out.println("Current stack: " + upnStack);
            processCharacter(character, upnStack);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("No Sleep :(");
            }
        }
        if (upnStack.size() != 1) {
            throw new IllegalArgumentException("Invalid UPN expression");
        }
        return upnStack.pop();
    }

    public static void processCharacter(char character, MyStack upnStack){
        if (Character.isDigit(character)) {
            upnStack.push(Integer.parseInt(String.valueOf(character)));
        } else {
            if (upnStack.size() < 2) {throw new IllegalArgumentException("Not enough operands before operator: " + character);}
            int firstNum = upnStack.pop();
            int secondNum = upnStack.pop();

            switch (character) {
                case '+' -> upnStack.push(firstNum + secondNum);
                case '*' -> upnStack.push(firstNum * secondNum);
                default -> throw new IllegalArgumentException("Unsupported operator: " + character);
            }
        }
    }

    public static boolean validate(List<Character> characterList) {
        MyStack myStack = new MyStack();

        for (char c : characterList) {
            if (Character.isDigit(c)) {
                myStack.push(c);
            } else if (c == '+' || c == '*') {
                if (myStack.size() < 2) {return false;}
                myStack.pop();
                myStack.pop();
                myStack.push('0');
            } else {return false;}
        }

        return myStack.size() == 1;
    }

}
