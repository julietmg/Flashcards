public class User {

    private String userName;
    int level;
    int correctAnswer;
    int wrongAnswer; //Czy wlasciwie warto zliczac prawidlowe i nieprawidlowe odpowiedzi? Chyba tylko o lvl chodzi


    public User (String userName, int level) {
        this.userName = userName;
        this.level = level; 

    }

    public void proceedTonextLevel (int correctAnswer, int wrongAnswer) {

        if (correctAnswer > wrongAnswer) {

            //Jak to zrobic? Trzebaby zaladowan nowa liste slow, trudniejsza


    }



    
}
