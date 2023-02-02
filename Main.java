import java.io.FileNotFoundException;
import java.util.*;

import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.root.Finished;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello! You're currently on level 1 of studying!");

        //User Maks  = new User("maksiu", 1); 

        Map<String, String> italianWords = DictionaryLoader.loadFromFile("Dictionaries/Level1_English_Italian.txt");

        String answer = "cat";
        int correctAnswer = 0;
        int wrongAnswer = 0;

        

        while (answer.isEmpty() == false) {

            ArrayList<String> activeCard = new ArrayList<String>(italianWords.keySet());
            String key = activeCard.get(new Random().nextInt(activeCard.size()));
            System.out.println(key);

            System.out.println("What's the answer?");
            answer = System.console().readLine();

            if (italianWords.get(key).equalsIgnoreCase(answer)) {
                System.out.println("This answer is correct!");
                correctAnswer = correctAnswer + 1; 
            }

            else {

                System.out.println("Unfortunately, this answer isn't correct.");
                System.out.println("The correct answer was: " + italianWords.get(key) + ".");
                wrongAnswer = wrongAnswer + 1; 

            }

        }

       if (answer.isEmpty() == true) {
        System.out.println("Your correct answers: " + correctAnswer);
        System.out.println("Your wrong answers: " + wrongAnswer);
       }

       if (wrongAnswer > correctAnswer) {
        System.out.println("You should practice more. Try to learn all these words by heart.");
       }

       else {
        System.out.println("Good job! The next level is waiting for you. ");
       }

       

    }

}


