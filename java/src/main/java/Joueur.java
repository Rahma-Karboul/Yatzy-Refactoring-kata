import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Joueur {
    private int score = 0;
    private static Set<Integer> categoriesInput;
    private final int maxRollNumber = 3;

    public void Jouer() throws CategoryNotFoundException {
    int currentRoll = 1;
    int[] currentDice;
    categoriesInput = new HashSet<>();

    try (Scanner scanner = new Scanner(System.in)) {
        while (currentRoll <= maxRollNumber){
            System.out.println("\nNouveau tour:");

            // Demander au joueur d'entrer manuellement les valeurs des dés
            currentDice = inputDiceValues();
            System.out.println("Résultat du lancer : " + Arrays.toString(currentDice));

            // Proposer au joueur de choisir une catégorie
            Category category = inputCategory(scanner);

            // Calculer le score pour le choix de catégorie
            Yatzy yatzy = new Yatzy(currentDice[0],currentDice[1],currentDice[2],currentDice[3],currentDice[4]);
            yatzy.setCategory(category);
            int scoreCategory = calculeScore(yatzy);
            score += scoreCategory;
            // Afficher le score
            System.out.println("Score pour la catégorie '" + category + "': " + scoreCategory);
            currentRoll++;
        }
    }catch(CategoryNotFoundException e){
        System.out.println("error");
    }
}
    public int calculeScore(Yatzy yatzy) throws CategoryNotFoundException {
        int scoreCategory = 0;
        switch(yatzy.getCategory()){
            case ONES -> scoreCategory += yatzy.ones();
            case TWOS -> scoreCategory += yatzy.twos();
            case THREES -> scoreCategory += yatzy.threes();
            case FOURS -> scoreCategory += yatzy.fours();
            case FIVES -> scoreCategory += yatzy.fives();
            case SIXES -> scoreCategory += yatzy.sixes();
            case PAIR -> scoreCategory += yatzy.pair();
            case TWOPARIES -> scoreCategory += yatzy.two_pairs();
            case YATZY -> scoreCategory += yatzy.yatzy();
            case CHANCE -> scoreCategory += yatzy.chance();
            case FULLHOUSE -> scoreCategory += yatzy.fullHouse();
            case FOUROFAKIND -> scoreCategory += yatzy.four_of_a_kind();
            case THREEOFAKIND -> scoreCategory += yatzy.three_of_a_kind();
            case LARGESTRAIGHT -> scoreCategory += yatzy.largeStraight();
            case SMALLSTRAIGHT -> scoreCategory += yatzy.smallStraight();
            default -> {
                System.out.println("Game over :( ");
                throw new CategoryNotFoundException();}
        }

        return scoreCategory;
    }
    private int[] inputDiceValues() {
        System.out.print("Entrez les valeurs des dés (séparées par un espace): ");
        Scanner scanner = new Scanner(System.in);
        String[] valuesStr = scanner.nextLine().split(" ");
        int[] cDice = new int[5];
        if(valuesStr.length >= 5) {
            for (int i = 0; i < Math.min(5, valuesStr.length); i++) {
                if (Integer.parseInt(valuesStr[i]) >= 1 && Integer.parseInt(valuesStr[i]) <= 6) {
                    cDice[i] = Integer.parseInt(valuesStr[i]);
                }
            }
        }else System.out.println("Error! retry game");
        return cDice;
    }

    private Category inputCategory(Scanner scanner) throws CategoryNotFoundException {
        int categoryInput;
        System.out.print("Voici la liste des catégories: \n");
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
        System.out.print("\n Attention, la catégorie ne pourra pas être réutilisée pour les tours restants de cette partie.");
        do {
            System.out.print("\nVeuillez entrer un numero de catégorie entre 1 et 15 : ");

            while (!scanner.hasNextInt()) {
                System.out.print("Veuillez entrer un ENTIER valide entre 1 et 15 : ");
                scanner.next(); 
            }

            categoryInput = scanner.nextInt();

        } while (categoryInput < 1 || categoryInput > 15 || (!categoriesInput.isEmpty() && categoriesInput.contains(categoryInput)));

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
    }
    public int getScore() {
        return score;
    }
}
