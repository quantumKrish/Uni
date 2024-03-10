
package ECS414U.midTermPractice;

import java.util.Arrays;

public class gptQ6 {

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
    
        System.out.println("Original Array:");
        print2DArray(array);
    
        transposeAndMultiply(array);
    
        System.out.println("\nTransformed and Sorted Array:");
        print2DArray(array);
    }
    
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    public static void transposeAndMultiply(int[][] array) {

        int[][] tempArray = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                tempArray[i][j] = array[j][i];
            }
        }


        for (int i = 0; i < array.length; i++) {

            int totalRow = 0;

            for (int j = 0; j < array.length; j++) {

                totalRow += array[i][j];

            }

            for (int k = 0; k < array.length; k++) {

                tempArray[i][k] = tempArray[i][k] * totalRow;

            }        
        }

        for (int i = 0; i < array.length; i++) {

            int totalCurrRow = 0;
            int totalNextRow = 0;

            for (int j = i + 1; j < array.length; j++) {



                for (int k = 0; k < array.length; k++) {

                    totalCurrRow += tempArray[i][k];
    
                } 

                for (int l = 0; l < array.length; l++) {

                    totalNextRow += tempArray[j][l];
    
                }             
                
                if (totalNextRow > totalCurrRow) {
                    int[] temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;  
                }
            }
        }

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                array[i][j] = tempArray[i][j];
            }
        }
    }
}
