public class Card {

    String frontSide;
    String backSide; 


    public void lookAtFront (String frontSide) {

        System.out.println(frontSide);

    }

    public void lookAtBack (String backSide) {

        System.out.println("The answer is: " + backSide + ".");
    }
    
}
