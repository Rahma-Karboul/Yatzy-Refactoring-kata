import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Joueur {
    private int score = 0;
    private static Set<Integer> categoriesInput;
    private final int maxRollNumber = 3;

    public void Jouer() throws CategoryNotFoundException {
    int currentRoll = 1;
    int[] currentDice;

    try (Scanner scanner = new Scanner(System.in)) {
        while (currentRoll <= maxRollNumber){
            System.out.println("\nNouveau tour:");

            // Demander au joueur d'entrer manuellement les valeurs des dés
            currentDice = inputDiceValues(scanner);
            System.out.println("Résultat du lancer : " + Arrays.toString(currentDice));

            // Proposer au joueur de choisir une catégorie
            Category category = inputCategory(scanner);

            // Calculer le score pour le choix de catégorie
            int scoreCategory = calculeScore(new Yatzy(currentDice[0],currentDice[1],currentDice[2],currentDice[3],currentDice[4]));
            score += scoreCategory;
            // Afficher le score
            System.out.println("Score pour la catégorie '" + category + "': " + scoreCategory);
            currentRoll++;
        }
    }
}
    public int calculeScore(Yatzy yatzy) throws CategoryNotFoundException {
        switch(Yatzy.getCategory()){
            case ONES -> score += yatzy.ones();
            case TWOS -> score += yatzy.twos();
            case THREES -> score += yatzy.threes();
            case FOURS -> score += yatzy.fours();
            case FIVES -> score += yatzy.fives();
            case SIXES -> score += yatzy.sixes();
            case PAIR -> score += yatzy.pair();
            case TWOPARIES -> score += yatzy.two_pairs();
            case YATZY -> score += yatzy.yatzy();
            case CHANCE -> score += yatzy.chance();
            case FULLHOUSE -> score += yatzy.fullHouse();
            case FOUROFAKIND -> score += yatzy.four_of_a_kind();
            case THREEOFAKIND -> score += yatzy.three_of_a_kind();
            case LARGESTRAIGHT -> score += yatzy.largeStraight();
            case SMALLSTRAIGHT -> score += yatzy.smallStraight();
            default -> {
                System.out.println("Game over :( ");
                throw new CategoryNotFoundException();}
        }

        return score;
    }
    private static int[] inputDiceValues(Scanner scanner) {
        System.out.print("Entrez les valeurs des dés (séparées par un espace): ");
        String[] valuesStr = scanner.nextLine().split(" ");
        int[] currentDice = new int[5];
        for (int i = 0; i < Math.min(5, valuesStr.length); i++) {
            if( Integer.parseInt(valuesStr[i]) >= 1 && Integer.parseInt(valuesStr[i]) <= 6){
                currentDice[i] = Integer.parseInt(valuesStr[i]);
            }
        }
        return currentDice;
    }

    private Category inputCategory(Scanner scanner) throws CategoryNotFoundException {
        System.out.print("Choisissez un numero catégorie: \n");
        System.out.print("\b 1 : CHANCE\n");
        System.out.print("\b 2 : YATZY\n");
        System.out.print("\b 3 : ONES\n");
        System.out.print("\b 4 : TWOS\n");
        System.out.print("\b 5 : THREES\n");
        System.out.print("\b 6 : FOURS\n");
        System.out.print("\b 7 : FIVES\n");
        System.out.print("\b 8 : SIXES\n");
        System.out.print("\b 9 : PAIR\n");
        System.out.print("\b 10 : TWOPARIES\n");
        System.out.print("\b 11 : THREEOFAKIND\n");
        System.out.print("\b 12 : FOUROFAKIND\n");
        System.out.print("\b 13 : SMALLSTRAIGHT\n");
        System.out.print("\b 14 : LARGESTRAIGHT\n");
        System.out.print("\b 15 : FULLHOUSE\n");
        System.out.print("\n\n Be careful, the category cannot be used again in the remaining goes for that game.");
        // while ida5el entier
        int categoryInput = Integer.parseInt(scanner.nextLine());

        if( categoryInput >= 1 && categoryInput <= 15 && (categoriesInput.isEmpty() || !categoriesInput.contains(categoryInput))){
            categoriesInput.add(categoryInput);
            switch (categoryInput){
                case 1 -> {return Category.CHANCE;}
                case 2 -> {return Category.YATZY;}
                case 3 -> {return Category.ONES;}
                case 4 -> {return Category.TWOS;}
                case 5 -> {return Category.THREES;}
                case 6 -> {return Category.FOURS;}
                case 7 -> {return Category.FIVES;}
                case 8 -> {return Category.SIXES;}
                case 9 -> {return Category.PAIR;}
                case 10 -> {return Category.TWOPARIES;}
                case 11 -> {return Category.THREEOFAKIND;}
                case 12 -> {return Category.FOUROFAKIND;}
                case 13 -> {return Category.SMALLSTRAIGHT;}
                case 14 -> {return Category.LARGESTRAIGHT;}
                case 15 -> {return Category.FULLHOUSE;}

                default -> throw new CategoryNotFoundException();
            }
        }else {throw new CategoryNotFoundException();}

    }
    public int getScore() {
        return score;
    }
    public static void setCategoriesInput(Set<Integer> categoriesInput) {
        Joueur.categoriesInput = categoriesInput;
    }
}
