package ECS414U.Lab2.lab2q4;

class lab2q4 {
    public static void main(String[] args) {
        Student4 student1 = Student4.register("John", 123);
        Student4 student2 = Student4.register("Jane", 456);
        Student4 student3 = Student4.register("John", 123);

        System.out.println(student1 == student3); // true
        System.out.println(student1 == student2); // false


        for (int i = 0; i < Student4.numberOfStudents; i++) {
            System.out.println(Student4.registeredStudents[i].name + " " + Student4.registeredStudents[i].id);
        }   
    }
                                                                                        
}