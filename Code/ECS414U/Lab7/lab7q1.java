package ECS414U.Lab7;

import java.util.ArrayList;

public class lab7q1 {
    

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        shiftByN(a, 2);

        System.out.println(a.toString());
    }

    public static ArrayList<Integer> shiftByN (ArrayList<Integer> arrayList, int n ) {

        for (int i = 0; i < n + 1; i++) {

            int temp = arrayList.remove(0);
            arrayList.add(temp);
        }

        return arrayList;

    }
    
}


