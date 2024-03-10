package ECS414U.midTermPractice;


class Accumulator {
private int[] A;

    public Accumulator(int[] X) {

        A= new int[X.length];
        for (int i=0; i<X.length; i++) {
            A[i] = X[i];
        }
    }

    public int SumProdA(int n) {

        int total = 0;

        for (int i = 0; i < n; i++) {

            total += A[i];
        }

        total = total * n;
        return total;
    }

}

public class resit2018q3 {
        public static void main(String args[]){ // you can use the main method to test your code

        int[] A = {2,4,3,5,8};

        int r=new Accumulator(A).SumProdA(3); //change argument to test different cases
        System.out.println(r);
    }
}
