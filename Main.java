import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.UserName;
import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.root.Finished;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello! You're currently on level 1 of studying!");
        System.out.println("What's your name?");

        String userName = System.console().readLine();

        User user = User.loadUserFromFile(userName); 

        Map<String, String> italianWords = DictionaryLoader.loadFromFile("Dictionaries/Level1_English_Italian.txt");

        String answer = "cat";
        
        while (answer.isEmpty() == false) {

            ArrayList<String> activeCard = new ArrayList<String>(italianWords.keySet());
            String key = activeCard.get(new Random().nextInt(activeCard.size()));
            System.out.println(key);

            System.out.println("What's the answer?");
            answer = System.console().readLine();

            if (answer.isEmpty()) {
                break;
            }

            if (italianWords.get(key).equalsIgnoreCase(answer)) {
                System.out.println("This answer is correct!");
                user.recordGuess(); 
            }
            else {
                System.out.println("Unfortunately, this answer isn't correct.");
                System.out.println("The correct answer was: " + italianWords.get(key) + ".");
                user.recordFailure();
            }
        }

       System.out.println("Your score is: " + (int)(user.score() * 100) + "%" );

       if (user.score() >= 0.8) {
        System.out.println("Good job! The next level is waiting for you.");
       }
       else {
        System.out.println("You should practice more. Try to learn all these words by heart.");
       }
       user.saveUserToFile();       
    }

}


