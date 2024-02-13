import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy {
    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return sumOfAllDice(d1, d2, d3, d4, d5);
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrences(d1, d2, d3, d4, d5);
        for (int count : counts) {
            if (count == 5) {
                return 50;
            }
        }
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumOfSpecificNumber(d1, d2, d3, d4, d5, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumOfSpecificNumber(d1, d2, d3, d4, d5, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumOfSpecificNumber(d1, d2, d3, d4, d5, 3);
    }

    public int fours() {
        int sum = 0;

        for (int die : dice)
            if (die == 4)
                sum += 4;

        return sum;
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumOfSpecificNumber(d1, d2, d3, d4, d5, 5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumOfSpecificNumber(d1, d2, d3, d4, d5, 6);
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrences(d1, d2, d3, d4, d5);

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2; // The pair value
            }
        }

        return 0; // No pair found
    }

    public static int two_pairs(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrences(d1, d2, d3, d4, d5);
        int pairCount = 0;
        int score = 0;

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairCount++;
                score += (i + 1) * 2;
            }
        }

        return pairCount == 2 ? score : 0; // Return the sum of two pairs if found, otherwise 0

    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceValues = { d1, d2, d3, d4, d5 };
        Map<Integer, Long> occurrences = Arrays.stream(diceValues)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Recherche de la première valeur avec au moins trois occurrences
        int result = occurrences.entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        // Calcul du score (somme des trois occurrences)
        return result * 3;
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] diceValues = { d1, d2, d3, d4, d5 };
        Map<Integer, Long> occurrences = Arrays.stream(diceValues)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Recherche de la première valeur avec au moins quatre occurrences
        int result = occurrences.entrySet().stream()
                .filter(entry -> entry.getValue() >= 4)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        return result * 4;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] sortedDice = { d1, d2, d3, d4, d5 };
        Arrays.sort(sortedDice);

        for (int i = 0; i < sortedDice.length - 1; i++) {
            if (sortedDice[i] != i + 1) {
                return 0;
            }
        }

        return 15; // Sum of 1, 2, 3, 4, and 5
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] sortedDice = { d1, d2, d3, d4, d5 };
        Arrays.sort(sortedDice);

        for (int i = 0; i < sortedDice.length - 1; i++) {
            if (sortedDice[i] != i + 2) {
                return 0;
            }
        }

        return 20; // Sum of 2, 3, 4, 5, and 6
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = countOccurrences(d1, d2, d3, d4, d5);

        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;

        for (int count : counts) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasTwoOfAKind = true;
            }
        }

        return (hasThreeOfAKind && hasTwoOfAKind) ? sumOfAllDice(d1, d2, d3, d4, d5) : 0;

    }

    /**************** Private methods *****************/
    private static int[] countOccurrences(int... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private static int sumOfAllDice(int... dice) {
        return Arrays.stream(dice).sum();
    }

    private static int sumOfSpecificNumber(int d1, int d2, int d3, int d4, int d5, int number) {
        int sum = 0;
        int[] diceValues = { d1, d2, d3, d4, d5 };

        for (int die : diceValues)
            if (die == number)
                sum += number;

        return sum;
    }
}