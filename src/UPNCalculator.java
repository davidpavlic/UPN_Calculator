import MyCollections.MyStack;

import java.util.List;

public class UPNCalculator {

    public static int calculate(List<Character> characterList) {
        MyStack upnStack = new MyStack();
        for (char character : characterList) {
            if (Character.isDigit(character)) {
                upnStack.add(Integer.parseInt(String.valueOf(character)));
            } else {
                int firstNum = upnStack.pop();
                int secondNum = upnStack.pop();
                switch (character) {
                    case '+':
                        upnStack.add(firstNum + secondNum);
                        break;
                    case '*':
                        upnStack.add(firstNum * secondNum);
                        break;

                }
            }
        }
        return upnStack.pop();
    }

    public static int calculateSteps(List<Character> characterList){
        MyStack upnStack = new MyStack();
        for (int x = 0; x < characterList.size();) {
            System.out.println("Characters to read: " + characterList);
            System.out.println("Current stack: " + upnStack);
            if (Character.isDigit(characterList.get(0))) {
                upnStack.add(Integer.parseInt(String.valueOf(characterList.get(0))));

            } else {
                int firstNum = upnStack.pop();
                int secondNum = upnStack.pop();
                switch (characterList.get(0)) {
                    case '+':
                        upnStack.add(firstNum + secondNum);
                        break;
                    case '*':
                        upnStack.add(firstNum * secondNum);
                        break;

                }
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("No Sleep :(");
            }
            characterList.remove(x);
        }
        return upnStack.pop();
    }

}
