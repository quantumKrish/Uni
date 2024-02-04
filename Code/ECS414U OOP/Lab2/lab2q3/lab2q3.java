package ECS414U.Lab2.lab2q3;

class Student {

    String name;
    int id;

    public Student (String name, int id) {  

        this.name = name;
        this.id = id;
    }
}

public class lab2q3 {

    public static void main(String[] args) {

        Student[] students = {
            new Student("John", 3),
            new Student("Alice", 2),
            new Student("Bob", 1),
            new Student("Bob", 5)
        };
        
        sortStudents(students);
        
        for (Student s : students)
            System.out.println("(" + s.name + "," + Integer.toString(s.id) + ")" );
        
    }

    public static void sortStudents(Student[] s) {

        Student tempRecord;
        int count = s.length;
    
        // Outer loop for the number of passes
        for (int pass = 0; pass < count - 1; pass++) {

            // Inner loop for comparing and swapping elements
            for (int currentIdx = 0; currentIdx < count - 1 - pass; currentIdx++) {
                int nextIdx = currentIdx + 1;
    
                // check if names are the same
                if ( (s[currentIdx].name ).equals( s[nextIdx].name))  {

                    // check which record has the higher id value
                    if ((s[currentIdx].id ) > s[nextIdx].id ) {

                        // swaps them
                        tempRecord = s[currentIdx];
                        s[currentIdx] = s[nextIdx];
                        s[nextIdx] = tempRecord;
                    }

                } else if (((s[currentIdx]).name).compareTo((s[nextIdx]).name) > 0) {

                    // Swap them
                    tempRecord = s[currentIdx];
                    s[currentIdx] = s[nextIdx];
                    s[nextIdx] = tempRecord;
                }
            }
        }
    }   
}
