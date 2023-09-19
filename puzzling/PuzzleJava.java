import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls(){
        System.out.println("Trolololololo");
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        Random randMachine = new Random();

        for(int i = 0; i < 10; i++){
            randomArray.add(randMachine.nextInt(21-1) + 1);
        }

        return randomArray;
    }

    public String getRandomLetter(){
        String[] lettersArray = {"a", "b", "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        Random randMachine = new Random();

        return lettersArray[randMachine.nextInt(26-0) + 0];
    }

    public String generatePassword(){
        String randomWord = "";
        for(int i = 0; i < 8; i++){
            randomWord += getRandomLetter();;
        }

        return randomWord;
    }

    public String getNewPasswordSet(int number){
        String randomWord = "";
        for(int i = 0; i < number; i++){
            randomWord += getRandomLetter();;
        }

        return randomWord;
    }
}