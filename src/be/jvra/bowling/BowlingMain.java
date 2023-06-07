package be.jvra.bowling;

import java.util.Scanner;

public class BowlingMain {
    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bowling Game!");

        for (int frame = 1; frame <= 2; frame++) {
            System.out.println("Frame " + frame);
            System.out.print("Enter the number of pins knocked down in roll 1: ");
            int roll1 = scanner.nextInt();
            game.roll(roll1);

            if (roll1 != 10) {
                System.out.print("Enter the number of pins knocked down in roll 2: ");
                int roll2 = scanner.nextInt();
                game.roll(roll2);
            }
        }

        System.out.println("Final Score: " + game.score());

        scanner.close();
    }
}
