import java.util.Scanner;

class candidateInfo {
    String name;
    int votes = 0;
}
// end of candiate class

public class exam2022q2 {
    public static void main(String[] args) {

        votingSystem();

    }

        
    public static void votingSystem () {

        // maximum number of candidates
        final int maxCandidates = 10;

        // create an array to store the records
        candidateInfo[] candiateArray = new candidateInfo[maxCandidates];

        for (int i = 0; i < maxCandidates; i ++) {
            createCandidate(i, candiateArray);

        }

        createVoteList(maxCandidates, candiateArray);

        for (int i = 0; i < maxCandidates; i ++) {
            takeVote(candiateArray, maxCandidates, i);

        }

        getWinner(candiateArray, maxCandidates);
    
    }


    public static void getWinner (candidateInfo[] candidateArray, int maxCandidates) {

        String winner = "";
        int previousVote = 0;
        int currentVotes = 0;

        for (int i = 0; i < maxCandidates; i ++) {

            currentVotes = candidateArray[i].votes;

            if (currentVotes > previousVote) {
                winner = getName(candidateArray[i]);
            }

            previousVote = currentVotes;

        }

        if ((candidateArray[previousVote].votes) == currentVotes) {

            winner = winner + " " +candidateArray[previousVote].name;
        }

        System.out.println("Winner(s): " + winner);

    }


    public static void takeVote (candidateInfo[] candiateArray, int maxCandidates, int i) {
        int vote = inputInt(getName(candiateArray[i]) + " who do you vote for? ");

        candiateArray[vote - 1].votes ++;

    }



    public static void createVoteList (int maxCandidates, candidateInfo[] candidateArray) {

        String message = "Voting: ";
                
        for (int i = 0; i < maxCandidates; i++) {
            message = message + " " + (i + 1) + "=" + getName(candidateArray[i]);

        }

        System.out.println(message);

    }



    public static String getName (candidateInfo candidate) {
        return candidate.name;
    }


    public static void createCandidate (int i, candidateInfo[] candiateArray) {

        String name = inputStr("Name " + (i + 1) + "? ");
        candiateArray[i] = createCandidateRecord(name);

    }


    // To create a record for a single candidate
    //
    public static candidateInfo createCandidateRecord (String name) {

        candidateInfo candidate = new candidateInfo();

        candidate.name = name;
        candidate.votes = 0;

        return candidate;
    }
    // end createEpisode



// ----------------------------------------- INPUT METHODS ----------------------------------------- //

    // take user input and checks if its an int value- loops if it isn't
    //
    public static int inputInt (String message) {

        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);

            if (scanner.hasNextInt() && answer < 10) { // checks if input in an integer and or is greater than 10
                answer = scanner.nextInt();
                validInput = true; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
         return answer;
    }
    // end inputInt
    

    public static String inputStr (String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String textinput = scanner.nextLine();
        
        return textinput;
    }
    // end inputString

// ------------------------------------------------------------------------------------------------- //

    
}
// end of exam2022q2
