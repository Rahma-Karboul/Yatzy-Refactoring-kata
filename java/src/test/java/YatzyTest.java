import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void yatzy_scores_50() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void ones_scores_sum_of_ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos_scores_sum_of_twos() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes_scores_sum_of_threes() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours_scores_sum_of_fours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives_scores_sum_of_fives() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes_scores_sum_of_sixes() {

        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void one_pair_scores_sum_of_pair() {
        assertEquals(6, Yatzy.pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.pair(5, 3, 6, 6, 5));
    }

    @Test
    public void two_pairs_scores_sum_of_each_pair() {
        assertEquals(16, Yatzy.two_pairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pairs(3, 3, 5, 5, 5));
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_same_dice() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
    }

    @Test
    public void four_of_a_kind_scores_sum_of_four_same_dice() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void smallStraight_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight_scores_sum_of_all_dice() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse_scores_sum_of_all_dice() {
        assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}