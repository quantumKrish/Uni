import java.util.Scanner;

//Initialises the variables to be used in the records
class episodeInfo
{
    int season;
    String title;
}//END episode_info

public class exam2023q2 {

    public static void main(String [] a)
    {
        outputMenu();
        episodeList();

    } // end of main method

    public static void outputMenu() {

        System.out.println("(1) Add episode (2) Search for title (3) List season (4) Exit");
    }


    // controls all the options the program can take and stores all the data that is used
    //
    public static void episodeList () {

        // Maximum number of records
        final int maxRecords = 1000;

        // Create an array to store the records
        episodeInfo[] episodesArray = new episodeInfo[maxRecords];

        // Keep track of the number of records added
        int numberOfRecords = 0;

        while (true) {

            int option = inputInt("Enter option [1-4]: ");

            if (option == 1) {
                addToList(numberOfRecords, episodesArray);
                numberOfRecords ++;
            } 
            else if (option == 2) {
                searchForEpisode(numberOfRecords, episodesArray);

            }
            else if (option == 3) {
                listSeason(numberOfRecords, episodesArray);

            }
            else if (option == 4) {
                break;

            } else {
                System.out.println("Invalid input !!! Enter number between 1 and 4");
                outputMenu();
            }
            // end of if else
        }
        // end of while loop
    }
    // end of episodeList


    // adds a record to the array by getting inputs then using a contructor method
    //
    public static void addToList (int numberOfRecords, episodeInfo[] episodesArray) {

        int episodeSeason = inputInt("Season number? ");
        String episodeTitle = inputStr("Title? ");

        // create a record and add it to the array
        episodesArray[numberOfRecords] = createEpisode(episodeTitle, episodeSeason);

    }


    // asks use for a title then iterates through array of records to find corresponding title and season
    //
    public static void searchForEpisode (int numberOfRecords, episodeInfo[] episodesArray) {

        String target = inputStr("Title to search for? ");
        int i = 0;
        boolean foundFlag = false;

        // loops as long as item is not found or i is less than the actual amount of records in the array
        while (i < numberOfRecords) {
            episodeInfo currentEpisode = episodesArray[i];
    
            // check if record is empty
            if (currentEpisode != null) {
                if ((getTitle(episodesArray[i])).equals(target)) {
                    System.out.println("Episode \"" + getTitle(episodesArray[i]) + "\" was in season " + getSeason(episodesArray[i]));
                    foundFlag = true;
                    break; // exits loop when target found

                } else {
                    i++;

                }
            } 
            // end of if else
        }
        // end of while loop

        // if the entire list was searched and the title was not found
        if (foundFlag == false) {
            System.out.println("Error title was not in the list !!!");

        }
    }
    // end of searchForEpisode


    // asks the user for the season they want the episodes of, loop checks each record if it's season is of the target's
    // then prints them to the user, if none are found then an empty message is printed
    //
    public static void listSeason (int numberOfRecords, episodeInfo[] episodesArray) {

        int seasonTarget = inputInt("Season number to list? ");
        boolean episodeFound = false;

        for (int i = 0; i < numberOfRecords; i++) {
            episodeInfo currentEpisode = episodesArray[i];
    
            // check if record is empty
            if (currentEpisode != null) {
                if (getSeason(currentEpisode) == seasonTarget) {
                    System.out.println("\"" + getTitle(currentEpisode) + "\"");
                    episodeFound = true;
                }
            }
        }
        // end of for loop

        if (episodeFound == false) {
        System.out.println("There was no episodes in this season !!!");

        }
    }
    // end of listSeason


    // To create a record for a single episode 
    //
    public static episodeInfo createEpisode (String episodeTitle, int episodeSeason) {

        episodeInfo episode = new episodeInfo();

        episode.title = episodeTitle;
        episode.season = episodeSeason;

        return episode;
    }
    // end createEpisode

    public static String getTitle (episodeInfo episode) {
        return episode.title;
    }

    public static int getSeason (episodeInfo episode) {
        return episode.season;
    }   


// ----------------------------------------- INPUT METHODS ----------------------------------------- //

    // take user input and checks if its an int value- loops if it isn't
    //
    public static int inputInt (String message) {

        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);

            if (scanner.hasNextInt()) { // checks if input in an integer
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

} // end of exam2023q2 class