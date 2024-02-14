import java.util.Arrays;

public class Yatzy {
    private final int[] dice;
    private Category category;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[] { d1, d2, d3, d4, d5 };
    }

    public int chance() {
        return sumOfAllDice();
    }

    public int yatzy() {
        if (dice[0] == dice[1] & dice[0] == dice[2] & dice[0] == dice[3] & dice[0] == dice[4]) {
            return 50;
        }
        return 0;
    }

    public int ones() {
        return sumOfSpecificNumber(1);
    }

    public int twos() {
        return sumOfSpecificNumber(2);
    }

    public int threes() {
        return sumOfSpecificNumber(3);
    }

    public int fours() {
        return sumOfSpecificNumber(4);
    }

    public int fives() {
        return sumOfSpecificNumber(5);
    }

    public int sixes() {
        return sumOfSpecificNumber(6);
    }

    public int pair() {
        int[] counts = countOccurrences();

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2;
            }
        }

        return 0;
    }

    public int two_pairs() {
        int[] counts = countOccurrences();
        int pairCount = 0;
        int score = 0;

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairCount++;
                score += (i + 1) * 2;
            }
        }

        return pairCount == 2 ? score : 0;

    }

    public int three_of_a_kind() {
        int[] counts = countOccurrences();
        for (int i = 0; i <= 5; i++) {
            if (counts[i] >= 3)
                return (i + 1) * 3;
        }
        return 0;
    }

    public int four_of_a_kind() {
        int[] counts = countOccurrences();
        for (int i = 0; i <= 5; i++) {
            if (counts[i] >= 4)
                return (i + 1) * 4;
        }
        return 0;
    }

    public int smallStraight() {
        int[] sortedDice = dice;
        Arrays.sort(sortedDice);

        for (int i = 0; i < sortedDice.length - 1; i++) {
            if (sortedDice[i] != i + 1) {
                return 0;
            }
        }

        return 15; // Sum of 1, 2, 3, 4, and 5
    }

    public int largeStraight() {
        int[] sortedDice = dice;
        Arrays.sort(sortedDice);

        for (int i = 0; i < sortedDice.length - 1; i++) {
            if (sortedDice[i] != i + 2) {
                return 0;
            }
        }

        return 20; // Sum of 2, 3, 4, 5, and 6
    }

    public int fullHouse() {
        int[] counts = countOccurrences();

        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;

        for (int count : counts) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasTwoOfAKind = true;
            }
        }

        return (hasThreeOfAKind && hasTwoOfAKind) ? sumOfAllDice() : 0;

    }

    public int[] countOccurrences() {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private int sumOfAllDice() {
        return Arrays.stream(dice).sum();
    }

    private int sumOfSpecificNumber(int number) {
        int sum = 0;

        for (int die : dice)
            if (die == number)
                sum += number;

        return sum;
    }

    public Category getCategory() {
        return category;
    }

    public Category setCategory(Category c) {
        return category = c;
    }

}