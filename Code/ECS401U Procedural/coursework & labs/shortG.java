import java.util.Scanner;

public class shortG {

    
public static void main(String [] a)
{
    GoalsAndMatches();
} // end of main method



public static void GoalsPerMatch ( int goals, int matches)
{

    // dividing goals by matches to get goals per match
    int GoalsPerMatch = goals / matches;
    System.out.println("Goals per match = " + GoalsPerMatch );
    return;
    
} // end of GoalsPerMatch


public static void MinutesPerGoal ( int goals, int matches)
{
    final double matchTime = 90.0;
    // double prefix lets the operation calculate float numbers to output a decimal value
    double MinutesPerGoal = (matches * matchTime) / goals;
    String finalValue = String.format("%.1f", MinutesPerGoal);

    System.out.println("Minutes per goal = " +  finalValue); 
    return;
    
} // end of MinutesPerGoal



// A method that lets the user input all the values needed
//
//

public static void GoalsAndMatches()
    {
    int matches;
    int goals;
    Scanner scanner = new Scanner(System.in);

    //lets user input number of matches
    System.out.println("How many matches have been played so far?");
    System.out.print("You must enter a value above 0\n");

    matches = scanner.nextInt();
    System.out.println("There were " + matches + " matches played.\n");

    //lets user input number of goals
    System.out.print("How many goals have been scored so far?");
    goals = scanner.nextInt();
    System.out.println("There were " + goals + " goals scored.");
    GoalsPerMatch(goals, matches);
    MinutesPerGoal(goals, matches);

    } // end of GoalsAndMatches

} // end of shortG class
