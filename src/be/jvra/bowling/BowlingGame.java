package be.jvra.bowling;

import java.util.Arrays;
import java.util.Scanner;

public class BowlingGame {
    private int[] rolls;
    private int currentRoll;

    public BowlingGame() {
        rolls = new int[21];
        currentRoll = 0;
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        System.out.println("These are my rolls =>" + Arrays.toString(rolls));
        System.out.println("These are the amount of rolls => " + rolls.length);
        int totalScore = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                totalScore += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                totalScore += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                totalScore += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return totalScore;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfPinsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }


}
