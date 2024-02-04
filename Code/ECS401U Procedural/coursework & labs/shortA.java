import java.util.Scanner;



public class shortA {
    
public static void main(String [] a)
    {
        simulateElection();
    } // end of main method
    // creates a class that hold all data related to the candiditates 
    static class candidate {

        String name;
        String party;
        int votes; 
        boolean won = false;

    } // end of candidate class

    // creates the records for each candidate then compares votes
    public static void simulateElection() {

        // initialises variables 
        String name = "";
        String party = "";
        int votes = 0;

        // creates instances of the records to be used
        candidate candidate1 = new candidate();
        candidate candidate2 = new candidate();

        int count = 0;

        candidate1.name = setName(name, count);
        candidate1.party = setParty(party);
        candidate1.votes = setVotes(votes);

        count++;

        
        candidate2.name = setName(name, count);
        candidate2.party = setParty(party);
        candidate2.votes = setVotes(votes);

        // function to find the candidate with most votes
        checkWinner(candidate1, candidate2);

    } // end of simulateElection

        // sets the name of candidates 
        public static String setName(String name, int count) {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                if (count == 0) {
                    System.out.println("Name of the first candidate: ");
                } else {
                    System.out.println("Name of the second candidate: ");
                }
    
                name = scanner.nextLine();
    
                if (!name.isEmpty()) {
                    break; // Break out of the loop if the name is not empty
                } else {
                    System.out.println("Invalid input. Please enter a valid name.");
                }
            }
    
            return name;
        }
    
        // sets the name of party 
        public static String setParty(String party) {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("Name of party: ");
                party = scanner.nextLine();
    
                if (!party.isEmpty()) {
                    break; // Break out of the loop if the party name is not empty
                } else {
                    System.out.println("Invalid input. Please enter a valid party name.");
                }
            }
    
            return party;
        }
    
        // sets the votes of the party
        public static int setVotes(int votes) {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("Number of votes: ");
    
                if (scanner.hasNextInt()) {
                    votes = scanner.nextInt();
                    break; // Break out of the loop if a valid integer is entered
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                }
            }
    
            return votes;
        }
    
    public static void checkWinner(candidate one, candidate two) {

        if (one.votes > two.votes) {

            System.out.println(one.name + " of the " + one.party + " party is declared the winner with " + one.votes + ".");
            System.out.println("They have a majority of " + (one.votes - two.votes));

        } else if (two.votes > one.votes) {

            System.out.println(two.name + " of the " + two.party + " party is declared the winner with " + two.votes + ".");
            System.out.println("They have a majority of " + (two.votes - one.votes));

        } else {

            System.out.println("There will be another election hosted due to a tie. ");
        }

    }

    
} // end of shortA class
