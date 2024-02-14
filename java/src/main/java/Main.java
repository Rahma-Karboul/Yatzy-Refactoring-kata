public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nBienvenue dans le jeu de Yatzy !");

        System.out.println("\nCommençons par le premier joueur !");
        Joueur joueur1 = new Joueur();
        try {
            joueur1.Jouer();
        } catch (CategoryNotFoundException e) {
            System.out.println("\nGame Over :( ");
        }
        System.out.println("\nBien joué! Votre score est: "+ joueur1.getScore());

    }

}
