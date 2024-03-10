package ECS414U.midTermPractice;

import java.util.Arrays;

public class gptQ5 {

    public static void main(String[] args) {
        int[][] array = {
            {3, 2, 5},
            {1, 4, 2},
            {5, 1, 7},
            {2, 3, 1}
        };
    
        System.out.println("Original Array:");
        print2DArray(array);
    
        sort2DArray(array, 1);
    
        System.out.println("\nSorted Array (Based on Column 1):");
        print2DArray(array);
    }
    
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    public static void sort2DArray(int[][] array, int columnIndex) {

        for (int i = 0; i < array.length; i++) {
    
            for (int j = i + 1; j < array.length; j++) {
    
                if (array[i][columnIndex] > array[j][columnIndex]) {
    
                    int[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;  
                }
            }
        }
    }
    
}
