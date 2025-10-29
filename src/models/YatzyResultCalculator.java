package models;

public class YatzyResultCalculator {
    /**
     * Used to calculate the score of throws with 5 dice
     * public class YatzyResultCalculator {
     * /
     **/
    private final Die[] dice;

    /**
     *
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        //TODO: implement YatzyResultCalculator constructor.
        /**/
        this.dice = dice;
    }

    /**
     * Calculates the score for Yatzy uppersection
     *
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */
    public int upperSectionScore(int eyes) {
        int sum = 0;
        for (Die d : dice) {
            if (d.getEyes() == eyes) {
                sum += eyes;
            }
        }
        return sum;

    }

    private int[] countEyes() {
        int[] counts = new int[7]; // index 1–6 bruges
        for (Die d : dice) {
            counts[d.getEyes()]++;
        }
        return counts;
    }

    public int onePairScore() {
        int[] c = countEyes();
        for (int i = 6; i >= 1; i--) {
            if (c[i] >= 2) return i * 2;
        }
        return 0;
    }

    public int twoPairScore() {
        int[] c = countEyes();
        int pairs = 0;
        int score = 0;
        for (int i = 6; i >= 1; i--) {
            if (c[i] >= 2) {
                pairs++;
                score += i * 2;
                if (pairs == 2) return score;
            }
        }
        return 0;
    }

    public int threeOfAKindScore() {
        int[] count3 = countEyes();
        for (int i = 6; i >= 1; i--) {
            if (count3[i] >= 3) return i * 3;
        }
        return 0;
    }

    public int fourOfAKindScore() {
        int[] count4 = countEyes();
        for (int i = 6; i >= 1; i--) {
            if (count4[i] >= 4) return i * 4;
        }
        return 0;
    }

    public int smallStraightScore() {
        int[] countS = countEyes();
        for (int i = 1; i <= 5; i++) {
            if (countS[i] != 1) return 0;
        }
        return 15; // fast score
    }

    public int largeStraightScore() {
        int[] countL = countEyes();
        for (int i = 2; i <= 6; i++) {
            if (countL[i] != 1) return 0;
        }
        return 20; // fast score
    }

    public int fullHouseScore() {
        int[] countFull = countEyes();
        int three = 0, two = 0;

        for (int i = 1; i <= 6; i++) {
            if (countFull[i] == 3) {
                three = i * 3;
            }
            if (countFull[i] == 2) {
                two = i * 2;
            }
        }
        if (three > 0 && two > 0) {
            return three + two;
        } else {
            return 0;
        }
    }

    public int chanceScore() {
        int sum = 0;
        for (Die d : dice)
            sum += d.getEyes();
        return sum;
    }

    public int yatzyScore() {
        int first = dice[0].getEyes();
        for (Die d : dice) {
            if (d.getEyes() != first) return 0;
        }
        return 50;
    }
}