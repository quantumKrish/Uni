 /* ***************************************
  @author    Kirishanth
  @SID       230612008
  @date      06 Nov 2023
  @version   1

    Miniproject Level 4 / 5
   ****************************************/
import java.util.Scanner;
import java.util.Random;


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
        System.out.println("Incorrect gender");
        petBirth();        
    } else if (bdayCheck == false) {
        System.out.println("Incorrect birthday");
        petBirth();       
    } else {
        System.out.println("Data all correct!! > . <");

        if (gender.equals("him")) {
            System.out.println("Welcome " + name + " to this new world, his birthday is " + bday_day + "/" + bday_month + "/" + bday_year );
        } else {
            System.out.println("Welcome" + name + "to this new world, her birthday is " + bday_day + "/" + bday_month + "/" + bday_year );

        }
    
    }

}


// asks user to listen to some songs then answer some questions about them, at random a minigame in can appear after every round
// (Level C,D / 4,5)
//
// array of all songs
    String[] songs= {"Don't Say No", "Remember Me", "Paraglide", "Running Through The Night", 
                    "Overflow", "WA-R-R", "Broken Love", "SLOW DANCING IN THE DARK", "fairy", "Sun&Moon", 
                    "kiss me thru the phone", "Mmmh", "Calico", "Ballroom Extravaganza", "zombie pop", "mon amour",
                    "People", "Infrared Camera", "What is Love?", "Nonviolent Communication"};
                    
    // array of all song's artists
    String[] artists = {"SURL", "PENOMECO", "Whee In", "Seori", "jeebanoff", "colde", "GEMINI", "Joji", "Dvwn", "NCT 127",
                        "CLUB BOYBND", "KAI", "DPR IAN", "DPR IAN", "DPR IAN", "GEMINI", "Agust D", "Wonstein",
                        "LeeHi", "Metro Boomin"};

    // array of all song's links

    String[] links = {"https://open.spotify.com/track/2AmFJKuVIdW7fayLvZQ3aR?si=944e71271f4d4f72", 
                    "https://open.spotify.com/track/0MlU6mThXuHwRJ3pt8TYt4?si=8dd80434ec6c48a2", 
                    "https://open.spotify.com/track/6dmRJBF95zrUIB2BXFCHDc?si=b1c0a43ca2ef42de", 
                    "https://open.spotify.com/track/3UZ46DvXvB2R7sBUZornlv?si=fcffc9d550bd4854", 
                    "https://open.spotify.com/track/5K04nRvbEVPSTbv4wjNSzw?si=5ed3d0289a1e47e3", 
                    "https://open.spotify.com/track/1ZEFYW6nPEvIcsIvymgsLk?si=c5b9fe17d6f94436",
                    "https://open.spotify.com/track/6GehOJs060WzAi78QArj7p?si=5cbb9a80e34445de",
                    "https://open.spotify.com/track/0rKtyWc8bvkriBthvHKY8d?si=6556f3d57ae34f72",
                    "https://open.spotify.com/track/1FGXujttO5H6XB25NlG3Yd?si=3da7c46197ae435e",
                    "https://open.spotify.com/track/4jhUqSKsWZoVOc778NsFU1?si=299dcf065c0f4b6c",
                    "https://open.spotify.com/track/4KvxaOvVMSNlTO3ZowMm9E?si=fd2165309e2b48e9",
                    "https://open.spotify.com/track/5dntGTbUtmUO239wQ0k3yM?si=5bb00541e2c147cd",
                    "https://open.spotify.com/track/6rgMOrZmsa3eKZfRSw1587?si=61a43113dacd4db5",
                    "https://open.spotify.com/track/4vJfBno2d0mTjMcYn5lEln?si=9bda6e6a51574ae4",
                    "https://open.spotify.com/track/5zhMMVw097YOSvT0oDGgDV?si=0fcb0a5fbadd47dd",
                    "https://open.spotify.com/track/2X2iPcwho1LGm2XWUqhOJH?si=a6f917821aaa4fd5",
                    "https://open.spotify.com/track/6HDHaCnH2FCSdEwXrJfEVF?si=34835ac2367048e6",
                    "https://open.spotify.com/track/0YRuXgAFpfsIx8GgsJBJu3?si=42b598a0a94e4c9c",
                    "https://open.spotify.com/track/3lc5fY2NwKXNdchJtx58kR?si=5d91ab3a626a4d44",
                    "https://open.spotify.com/track/3xMnPIvsaWwzHzqqzaihEX?si=1b0b77335ab54f45",};



public static void gameTime(String name, String[] songs, String[] artists, String[] links) {

Scanner scanner = new Scanner(System.in);
Random random = new Random();



String artistAns;
String songAns;
double rating = 0.0;
double score = 0.0;
double percent = 0.0;
double totalScore = 0.0;
double miniRound = 0.0;


  
// Generate a random number between 2 and 6 (inclusive) for the amount of rounds going to be played
final int rounds = random.nextInt(3) + 3;

// text based instructions
System.out.println("We're gonna play " + rounds + " rounds. Get ready >:) \n");
System.out.println("Here are the rules:");
System.out.println("1. A random song link will appear, click on it and listen to it.");
System.out.println("2. Guess the song name and artist without looking. ");
System.out.println("3. Then rate the song from 1 - 5 \n");
System.out.println("Answer correctly or " + name + " will suffer from your mistakes. \n");


// for loop that asks the questions, collects answers and compares them to the right ones
for (int i = 0; i < rounds; i++) {
    System.out.println("Round " + (i + 1) + "!!!");
    int songPos = random.nextInt(songs.length);
    System.out.println("Listen to this:" + links[songPos]);

    System.out.println("\nWho do you think is the artist?");
    artistAns = scanner.nextLine();

    System.out.println("\nWhat do you think is the name of the song?");
    songAns = scanner.nextLine();
    
    System.out.println("\nWhat do you rate the from from 1 - 5? (1 being absolute garbage and 5 being sucked up into heaven)");
    rating = scanner.nextInt();

    // Consume the newline character
    scanner.nextLine();

    score = 0.0;

    if (artistAns.equals(artists[songPos])) {
        score = score + 2.0;
    } 
    
        if (songAns.equals(songs[songPos])) {
        score = score + 2.0;
    }

    score = score + rating;

    totalScore = totalScore + score;

    System.out.println("You scored " + score + " this round?" );

    // minigame loop

    // only start minigame 12% of the time
    if (random.nextInt(6) == 0) {
        
        boolean playGame = true;
        while (playGame) {
            
            int randomNumber = random.nextInt(6) + 1; // Generate a random number between 1 and 6
            int attempts = 0;
            System.out.println("Random event: Guess the number between 1 and 6.");

            while (attempts < 3) {
                miniRound = miniRound + 1;
                System.out.println("Attempt " + (attempts + 1) + ": Enter your guess:");
                int userGuess = scanner.nextInt();
                scanner.nextLine();

                // if player guesses right number score increases by 10, if not score decreases by 2

                if (userGuess == randomNumber) {
                    System.out.println("A mysterious presence fades away. Your pet seems content.");
                    totalScore = totalScore + 10.0;
                    break;
                } else {
                    System.out.println("The atmosphere grows thick. Your pet suffocates.");
                    totalScore = totalScore - 2.0;
                }

                attempts = attempts + 1;

            } // end of inner while loop
        
            // lets player decide whether they want to go again or not

            System.out.println("Continue the journey? (yes/no)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                playGame = false;
            }

        } // end of outter while loop

    } // end of if statement

} // end of for loop


// displays scores

System.out.println("You scored " + totalScore + " points out of " + ((rounds * 9) + (miniRound * 10)));
percent = (totalScore / ((rounds * 9.0) + (miniRound * 10))) * 100.0;
System.out.println("That is " + Math.round(percent) + "% well done!");

} // end of gameTime

}