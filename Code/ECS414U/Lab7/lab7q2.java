package ECS414U.Lab7;

import java.util.ArrayList;

public class lab7q2 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(2);

        System.out.println(getOverlap(a, b).toString());
    }

    public static ArrayList<Integer> getOverlap (ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {

        ArrayList <Integer> newArrayList = new ArrayList<>();

        for (int i = 0; i < arrayList1.size(); i++) {

            for (int j = 0; j < arrayList2.size(); j++) {

                if (arrayList1.get(i) == arrayList2.get(j)) {

                    newArrayList.add(arrayList2.get(j));
                }
            }
        }

        return newArrayList;
    }
}
