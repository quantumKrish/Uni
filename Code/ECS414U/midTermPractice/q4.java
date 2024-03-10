package ECS414U.midTermPractice;

public class q4 {

    public static void main(String[] args) {
        
    }
    


    public static void dbl (int[][] array) {
        
        int rows = array.length;
        int columns = array[0].length;
        
        for (int i = 0; i < rows; i++ ) {
            
            for (int j = 0; j < columns; j++) {
                
                array[i][j] = array[i][j] * 2;
            }
        }
        
    }
}
