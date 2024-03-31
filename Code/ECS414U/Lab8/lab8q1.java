package ECS414U.Lab8;

public class lab8q1 {

    public static void main(String[] args) {

        Integer[] a = new Integer[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        System.out.println(getValue(a, 3));
    }
    
    static <T> T getValue(T[] array, int index) {

        try {

            return array[index];

        } catch ( ArrayIndexOutOfBoundsException e) {

            System.out.println("Array index out of bounds");
            return null;
        }
    }
}
