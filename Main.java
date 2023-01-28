import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, String> italianWords = DictionaryLoader.loadFromFile("Dictionaries/English_Italian.txt");

        ArrayList<String> activeCard = new ArrayList<String>(italianWords.keySet());
        String key = activeCard.get(new Random().nextInt(activeCard.size()));
        System.out.println(key);

        System.out.println("What's the answer?");
        String answer = System.console().readLine();

        if (italianWords.get(key).equalsIgnoreCase(answer)) {
            System.out.println("This answer is correct!");
        }

        else {

            System.out.println("Unfortunately, this answer isn't correct.");
            System.out.println("The correct answer was: " + italianWords.get(key) + ".");

        }

    }

}