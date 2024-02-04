import java.util.Scanner;

public class shortF {

    public static void main(String [] a)
    {
        gradeCollection();
    } // end of main method

// calls method that records and stores grade data
//
public static void gradeCollection()
{
    // initalise the variables used to hold all values, methods (scanner) and temp variables
    //

    
    Scanner scanner = new Scanner(System.in);

    int grade;
    String t1_grade;
    String t2_grade;
    String d1_grade;
    String d2_grade;
    String p1_grade;
    String p2_grade;


    // prints the grade menu, declares the value as a constant using final, runs gradeMatcher method and assigns the letter value to
    // another variable
    System.out.println("Test 1: What is your 1st theory grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int theory1 = grade;
    t1_grade = gradeMatcher(grade);
    
    System.out.println("Test 1: What is your 1st dry run grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int dry1 = grade;
    d1_grade = gradeMatcher(grade);

    
    System.out.println("Test 1: What is your 1st program grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int program1 = grade;
    p1_grade = gradeMatcher(grade);

    
    System.out.println("Your grades were: " + t1_grade + " " + d1_grade + " " + p1_grade);
    System.out.println("\n");
    

    System.out.println("Test 2: What is your 2st theory grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int theory2 = grade;
    t2_grade = gradeMatcher(grade);

    
    System.out.println("Test 2: What is your 2st dry run grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int dry2 = grade;
    d2_grade = gradeMatcher(grade);

    
    System.out.println("Test 2: What is your 2st program grade? 1)A+ 2)A 3)B 4)C 5)D 6)F 7)G ");
    grade =  scanner.nextInt();
    final int program2 = grade;
    p2_grade = gradeMatcher(grade);

    
    System.out.println("Your grades were: " + t2_grade + " " + d2_grade + " " + p2_grade);
    System.out.println("\n");

    

    compareGrades(theory1, theory2, dry1, dry2, program1, program2);

    return;
} // END gradeCollection



// calls method that matches grade with number
//
public static String gradeMatcher(int grade)
{
    String letterGrade = "";
    
    if (grade == 1) {
    letterGrade = "A+";
        
    } else if (grade == 2) {
    letterGrade = "A";
        
    } else if (grade == 3) {
    letterGrade = "B";
        
    } else if (grade == 4) {
    letterGrade = "C";

    } else if (grade == 5) {
    letterGrade = "D";

    } else if (grade == 6) {
    letterGrade = "F";

    } else if (grade == 7) {
    letterGrade = "G";

    } else {
    System.out.println("Grade is invalid");

    }

    // returns the variable so it can be assigned to another variable from the function call
    return letterGrade;

    
} // END gradeCollection


// Compare all the grades and output the highest
//
public static void compareGrades(int theory1,int theory2,int dry1, int dry2,int program1,  int program2 )
{
    // intialises final variables
    //
    int theory;    
    int dry;
    int program;    
    int grade;
    String strTheory;
    String strDry;
    String strProgram;

    
     // comparison for theory
     if (theory1 < theory2) {
        theory = theory1;
     } else {
        theory = theory2;
     }
    grade = theory;
    strTheory = gradeMatcher(grade);
    

    // comparison for dry
    if (dry1 < dry2) {
        dry = dry1;
     } else {
        dry = dry2;
     }
    grade = dry;
    strDry = gradeMatcher(grade);
    

    // comparison for program
    if (program1 < program2) {
        program = program1;
     } else {
        program = program2;
     }
    grade = program;
    strProgram = gradeMatcher(grade);
    

    System.out.println("Your final test grades are Theory: " + strTheory + ", Dry: " + strDry + ", Program: " + strProgram);

     return;
    
} // END compareGrades
    
}
