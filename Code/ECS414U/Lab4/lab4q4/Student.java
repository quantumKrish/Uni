package ECS414U.Lab4.lab4q4;

class Student extends Person{


    private String SID;

    public Student(String name, int age, String SID) {

        

        super(name, age);
        this.SID = SID;

    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("SID: " + SID);
    }

}
