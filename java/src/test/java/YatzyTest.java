import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy_scores_50() {
        assertEquals(50, new Yatzy(4, 4, 4, 4, 4).yatzy());
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void ones_scores_sum_of_ones() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void twos_scores_sum_of_twos() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void threes_scores_sum_of_threes() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void fours_scores_sum_of_fours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives_scores_sum_of_fives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_scores_sum_of_sixes() {

        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair_scores_sum_of_pair() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).pair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).pair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).pair());
    }

    @Test
    public void two_pairs_scores_sum_of_each_pair() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).two_pairs());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).two_pairs());
    }

    @Test
    public void three_of_a_kind_scores_sum_of_three_same_dice() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).three_of_a_kind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).three_of_a_kind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).three_of_a_kind());
    }

    @Test
    public void four_of_a_kind_scores_sum_of_four_same_dice() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).four_of_a_kind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).four_of_a_kind());
        assertEquals(12, new Yatzy(3, 3, 3, 3, 3).four_of_a_kind());
    }

    @Test
    public void smallStraight_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight_scores_sum_of_all_dice() {
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void fullHouse_scores_sum_of_all_dice() {
        assertEquals(8, new Yatzy(1, 1, 2, 2, 2).fullHouse());
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
    }

    @Test
    public void testOccurrance(){
        assertEquals(3,new Yatzy(4, 4, 4, 5, 5).countOccurrences()[3]);
        assertEquals(2,new Yatzy(4, 4, 4, 5, 5).countOccurrences()[4]);
        assertEquals(0,new Yatzy(4, 4, 4, 5, 5).countOccurrences()[0]);
    }
}