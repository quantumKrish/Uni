/* ***************************************
  @author    Kirishanth
  @SID       230612008
  @date      31 October 2023
  @version   1

    Miniproject Level 3
    Pet Program
   ****************************************/

import java.util.Scanner;

class miniProject
{

    public static void main(String [] a)
    {
        welcomeMessage();
        petBirth();
    } // end of main method

// print a welcome message (level G minus / 1)
//
public static void welcomeMessage ()
{
    System.out.println("Welcome to the Pet Care Game! Get ready to nurture, play, and bond with your adorable virtual pets. Let the fun begin!");
    System.out.println("Look after your pet and make sure they don't die a horrible death :D\n\n");
}

// collects data about the pet's information and stores them in a variable (level G / 2)
//
public static void petBirth ()
{
    final String name;
    final int bday_day;
    final int bday_month;
    final int bday_year;
    final String gender;
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Information about your pet is irreversible so make sure you are sure before you press enter ಠ_ಠ\n");

    name = getName("\nWhat are you gonna name your pet panda?");
    System.out.println("\nWhat day was your pet panda born on?");
    bday_day = scanner.nextInt();
    System.out.println("\nWhat month was your pet panda born on?");
    bday_month = scanner.nextInt();
    System.out.println("\nWhat year was your pet panda born on?");
    bday_year = scanner.nextInt();
    System.out.println("\nWhat gender is your pet panda? (enter him or her)");
    gender = scanner.nextLine();

    checkData(bday_day, bday_month, bday_year, gender, name);
    
    return;
} // END petBirth


public static String getName(String question) {

String name;

System.out.println(question);
Scanner scanner = new Scanner(System.in);

name = scanner.nextLine();

return name;
}

// Asks the users name then greets them by name (level F / 3)
//
public static void checkData(int bday_day, int bday_month, int bday_year, String gender, String name) {

    // Initialize the flag variables
    Boolean genderCheck;
    Boolean bdayCheck;

    // Check the gender and birthday variables against the rules and set the flags to true or false
    if (gender.equals("him") || gender.equals("her")) {
        genderCheck = true;
    } else {
        genderCheck = false;
    }

    if (bday_day > 31 || bday_month > 12 || bday_day < 1 || bday_month < 1) {
        bdayCheck = false;
    } else {
        bdayCheck = true;
    }

    // Check if the flag variables are true or false, then output the appropriate response
    if (genderCheck == false) {
        System.out.println("Incorrect gender, your pet's gender lies in another timeline");
        
    } else if (bdayCheck == false) {
        System.out.println("Incorrect birthday, your pet's birthday lies on an otherworldly calendar");
     
    } else {
        System.out.println("Data all correct!! > . <");

        if (gender.equals("him")) {
            System.out.println("Welcome " + name + " to this new world, his birthday is " + bday_day + "/" + bday_month + "/" + bday_year );
        } else {
            System.out.println("Welcome" + name + "to this new world, her birthday is " + bday_day + "/" + bday_month + "/" + bday_year );

        }
    
    }

}

}