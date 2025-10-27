package models;

import java.util.Arrays;

/**
 * Used to calculate the score of throws with 5 dice
 */
public class YatzyResultCalculator {
    private int[] yatzyResult = new int[5];

    /**
     *
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        for (int i = 0; i < dice.length; i++) {
            yatzyResult[i] = dice[i].getEyes();

        }
        Arrays.sort(yatzyResult);
        //TODO: implement YatzyResultCalculator constructor.
    }

    /**
     * Calculates the score for Yatzy uppersection
     *
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */

    public int upperSectionScore(int eyes) {
        int sum = 0;
        for (int eye : yatzyResult) {
            if (eye == eyes) {
                sum += eye;
            }
        }
        return sum;
    }

    public int onePairScore() {
        for (int i = yatzyResult.length - 1; i > 0; i--) {
            if (yatzyResult[i] == yatzyResult[i - 1]) {
                return yatzyResult[i] * 2;
            }
        }
        return 0;
    }

    public int twoPairScore() {
        int pairSum = 0;
        int pairFound = 0;
        for (int i = yatzyResult.length - 1; i > 0; i--) {
            if (yatzyResult[i] == yatzyResult[i - 1]) {
                pairSum += yatzyResult[i] * 2;
                pairFound++;
                i--;
            }
            if (pairFound == 2) {
                return pairSum;
            }
        }
        return 0;
    }

    public int threeOfAKindScore() {
        for (int i = yatzyResult.length - 1; i >= 2; i--) {
            if (yatzyResult[i] == yatzyResult[i - 1] && yatzyResult[i] == yatzyResult[i - 2]) {
                return yatzyResult[i] * 3;
            }
        }
        return 0;
    }

    public int fourOfAKindScore() {
        for (int i = yatzyResult.length - 1; i >= 3; i--) {
            if (yatzyResult[i] == yatzyResult[i - 1] && yatzyResult[i] == yatzyResult[i - 2] && yatzyResult[i] == yatzyResult[i - 3]) {
                return yatzyResult[i] * 4;
            }
        }

        return 0;
    }

    public int smallStraightScore() {
        int[] expected = {1, 2, 3, 4, 5};
        if (Arrays.equals(yatzyResult, expected)) {
            return 15;
        }
        return 0;
    }

    public int largeStraightScore() {
        int[] expected = {2, 3, 4, 5, 6};
        if (Arrays.equals(yatzyResult, expected)) {
            return 20;
        }
        return 0;
    }

    public int fullHouseScore() {

        for (int i : yatzyResult) {
            if (yatzyResult[i] == yatzyResult[i + 1] && yatzyResult[i] == yatzyResult[i + 2]) {
                return yatzyResult[i] * 4;

            }
            return 0;
        }
    }

    public int chanceScore() {
        //TODO: implement chanceScore method.
        return 0;
    }

    public int yatzyScore() {
        //TODO: implement yatzyScore method.
        return 0;
    }

    public int[] rollTwoDice(RaffleCup Dice) {
        int[] faces = rollTwoDice();
        Dice[faces[0] - 1]++;
        Dice[faces[1] - 1]++;
        if (faces[0] == faces[1]) {
            sameNumberOfEyes++;
        }
    }
}

