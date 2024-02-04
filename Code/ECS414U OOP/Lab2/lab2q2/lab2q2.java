package ECS414U.Lab2.lab2q2;


class Student {

    String name;
    int id;

    public Student (String name, int id) {  

        this.name = name;
        this.id = id;
    }


    static boolean checkDuplicates(Student[] s) {

        int count = s.length;

        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (s[i].id == s[j].id) {

                    return true;

                }
            }
        }

        return false;
    }
}


public class lab2q2 {
    public static void main(String[] args) {

        Student[] studentsArrayWithDuplicate = {
                new Student("Alice", 1),
                new Student("Bob", 2),
                new Student("Charlie", 3),
                new Student("Alice", 1)
        };

        Student[] studentsArrayWithoutDuplicate = {
                new Student("Alice", 1),
                new Student("Bob", 2),
                new Student("Charlie", 3),
                new Student("David", 4)
        };

        System.out.println(Student.checkDuplicates(studentsArrayWithDuplicate));
        System.out.println(Student.checkDuplicates(studentsArrayWithoutDuplicate));
    }
}
