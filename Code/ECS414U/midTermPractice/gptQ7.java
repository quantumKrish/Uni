package ECS414U.midTermPractice;

public class gptQ7 {

    public static void main(String[] args) {
        Integer[] x = {1, 2, 3, 5, 2};
        Integer[] y = {4, 0, 7, 0};
        Integer[] z = {4, 3, 2, 3, 7};
    
        System.out.println(atLeastOneCommon(x, y)); // Should return false
        System.out.println(atLeastOneCommon(x, z)); // Should return true
    
        Integer[][] a = {{2, 4}, {1, 1}, {3, 3}};
        Integer[][] b = {{2, 4, 4}, {1, 0, 3}, {6, 5, 6}, {7, 3, 9}};
    
        System.out.println(allArraysDisjoint(a)); // Should return true
        System.out.println(allArraysDisjoint(b)); // Should return false
    }
    
    public static <T> boolean atLeastOneCommon(T[] array1, T[] array2) {

        for (int i = 0; i < array1.length; i++) {

            for (int j = 0; j < array2.length; j++) {

                if (array1[i].equals(array2[j])) {

                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static <T> boolean allArraysDisjoint(T[][] arrays) {

        for (int i = 0; i < arrays.length - 1; i++) {

            for (int j = 0; j < arrays[i].length; j++) {

                for (int k = i + 1; k < arrays.length; k++) {

                    for (int l = 0; l < arrays[k].length; l++) {

                        if (arrays[i][j].equals(arrays[k][l])) {

                            // Found a common element, arrays are not disjoint
                            return false;
                        }
                    }
                }
            }
        }
        
        // No common elements found, arrays are disjoint
        return true;
    }



}
