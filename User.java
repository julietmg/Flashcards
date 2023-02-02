import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

    private String userName;
    // int level;
    private int correctAnswer;
    private int wrongAnswer; //Czy wlasciwie warto zliczac prawidlowe i nieprawidlowe odpowiedzi? Chyba tylko o lvl chodzi


    private User(String userName, int correctAnswer, int wrongAnswer) {
        this.userName  = userName;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public User (String userName) {
        this.userName = userName;
        this.correctAnswer = 0;
        this.wrongAnswer = 0; 
        // this.level = level; 

    }

    public void recordGuess () {
        correctAnswer ++; 
    }

    public void recordFailure () {
        wrongAnswer ++; 
    }

    public double score () {
        return correctAnswer/(1.0 * wrongAnswer + correctAnswer); 
    }



    public void saveUserToFile() {
        String filename = userName + ".txt";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(userName + "," + correctAnswer + "," + wrongAnswer);
            writer.close();
            System.out.println("Saved the state into " + filename + ".");
          } catch (IOException e) {
            System.out.println("An error occurred when saving the state.");
            e.printStackTrace();
          }
    }

    public static User loadUserFromFile(String userName) {
        String filename = userName + ".txt";

        FileInputStream fis;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            return new User(userName);
        }
        Scanner sc = new Scanner(fis);
        String firstLine = sc.nextLine();
        sc.close();

        int firstCommaPosition = -1;
        int secondCommaPosition = -1;

        for (int i = 0; i < firstLine.length(); i++) {
            if (firstLine.charAt(i) == ',') {
                if(firstCommaPosition == -1) {
                    firstCommaPosition = i;
                } else {
                    secondCommaPosition = i;
                }
            }
        }

        String name = firstLine.substring(0, firstCommaPosition);
        String correctAnswerString = firstLine.substring(firstCommaPosition + 1, secondCommaPosition);
        String wrongAnswerString = firstLine.substring(secondCommaPosition + 1, firstLine.length());
        
        return new User(name, Integer.parseInt(correctAnswerString), Integer.parseInt(wrongAnswerString));
    }

    // public void proceedTonextLevel (int correctAnswer, int wrongAnswer) {

    //     if (correctAnswer > wrongAnswer) {

    //         //Jak to zrobic? Trzebaby zaladowan nowa liste slow, trudniejsza


    // }



    
}
