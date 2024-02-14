public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Yatzy's game!");

        System.out.println("Let's begin with the first player !");
        Joueur joueur1 = new Joueur();
        try {
            joueur1.Jouer();
        } catch (CategoryNotFoundException e) {
            System.out.println("Game Over :( ");
        }
        System.out.println("Your total score is: "+ joueur1.getScore());

    }

}
