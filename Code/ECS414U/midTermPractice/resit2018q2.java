package ECS414U.midTermPractice;

public class resit2018q2 {
        
    String name;
    int yearOfBirth;
    int status;

    public resit2018q2(String name, int year){

        this.name = name;
        this.yearOfBirth = year;

        if ((2017- year) > 60) {

            status = 1;

        } else {

            status = 0;
        }

    }

    public String getValues(){

        return ""+name+" "+yearOfBirth+" "+status;
    }
    public static void main(String arg[]){ // you can use the main method to test your code

        System.out.println((new resit2018q2("Mike",1950).getValues()));
        System.out.println((new resit2018q2("Tom",2000).getValues()));
    }
} 


