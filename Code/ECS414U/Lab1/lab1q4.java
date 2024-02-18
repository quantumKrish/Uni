package ECS414U.Lab1;

public class lab1q4 {

    public static void main(String[] args) {

        int[] xs = {0,1,1,1};
        System.out.println( countDuplicates(xs) );
        
    }

    public static int countDuplicates(int[] xs) {
        int dupes = 0;
        int count = xs.length;


        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (xs[i] == xs[j]) {

                    dupes++;
                }
            }
        }

        return dupes;
    }
}
