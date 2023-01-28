import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String> italianWords = new HashMap<>();

        italianWords.put("Yes", "Si");
        italianWords.put("No", "No");
        italianWords.put("Here you are", "Prego");
        italianWords.put("Hello", "Ciao");
        italianWords.put("Good evening", "Buonasera");
        italianWords.put("I like", "Mi piace");

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

        }

        

    }

}