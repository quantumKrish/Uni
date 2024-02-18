package ECS414U.Lab2.lab2q4;


class Student4 {

    String name;
    int id;
    static int numberOfStudents = 0;
    static Student4[] registeredStudents = new Student4[30];


    private Student4(String name, int id) {

        this.name = name;
        this.id = id;
    }

    public static Student4 register(String name, int id) {

        // creates records
        Student4 studentRecord = new Student4(name,id);


        // Check for duplicates
        for (int i = 0; i < numberOfStudents; i++) {

            if (registeredStudents[i] != null && registeredStudents[i].name.equals(studentRecord.name) && registeredStudents[i].id == studentRecord.id) {
                
                // If a duplicate is found, return the existing record
                return registeredStudents[i];
            }
        }

        // If no duplicate is found, add the new student record
        registeredStudents[numberOfStudents] = studentRecord;
        numberOfStudents++;

        return studentRecord;
    }


}
