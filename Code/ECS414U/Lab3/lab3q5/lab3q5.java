package ECS414U.Lab3.lab3q5;

import java.util.Random;

public class lab3q5 {
    public static void main(String[] args) {

        probabilityPuzzle();
            
    }

    public static void probabilityPuzzle() {

        int redCounter = 0;
        int greenCounter = 0;


        for (int i = 0; i < 100000; i++) {

            Random rand = new Random();

            int redBalls = rand.nextInt(100) + 1;

            int chosenBall = rand.nextInt(100) + 1;

            if (chosenBall < redBalls) {

                redBalls--;

            }

            int secondChosenBall = rand.nextInt(99) + 1;

            if (secondChosenBall < redBalls) {

                redCounter++;

            } else {
        
                greenCounter++;
            }
        }

        System.out.println("Reds picked: " + redCounter);
        System.out.println("Greens picked: " + greenCounter);
        System.out.println("\nProbability of picking a red ball after picking a red ball: " + (double) redCounter / 100000);
        System.out.println("Probability of picking a green ball after picking a red ball: " + (double) greenCounter / 100000);
    }

    
}
