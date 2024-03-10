package ECS414U.midTermPractice;

import java.util.Arrays;

public class gptQ4 {

    public static void squareEvenElements(int[][] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] % 2 == 0) {

                    array[i][j] = array[i][j] * array[i][j];
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] arrayOfArrays = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Array:");
        printArrayOfArrays(arrayOfArrays);

        squareEvenElements(arrayOfArrays);

        System.out.println("\nUpdated Array (Square Even Elements):");
        printArrayOfArrays(arrayOfArrays);
    }

    public static void printArrayOfArrays(int[][] array) {
        for (int[] subArray : array) {
            System.out.println(Arrays.toString(subArray));
        }
    }
}
