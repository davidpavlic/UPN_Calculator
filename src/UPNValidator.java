import java.util.List;

public class UPNValidator {

    public static boolean validate(List<Character> characterList){
        for(int x = characterList.size(); x >= 0;){
            char firstChar, secondChar, thirdChar;

            thirdChar = characterList.get(x-1);
            if(characterList.size() == 1 && Character.isDigit(thirdChar))
                return true;

            firstChar = characterList.get(x-3);
            secondChar = characterList.get(x-2);

            if(Character.isDigit(firstChar) && Character.isDigit(secondChar) && (thirdChar == '+' || thirdChar == '*')){
                characterList.remove(x-1);
                characterList.remove(x-2);
                x = characterList.size();
            }else{
                x--;
            }
        }
        return false;
    }
}
