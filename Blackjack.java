import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P1Random rand = new P1Random();
        int cardNumber;
        boolean gamePlay = true;
        int handValue;
        boolean menuOptions;

        // Variables are set to 0 at first then updated within the loop(s) after every new game
        int num = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int tiedGames = 0;
        int totalGames = 0;
        double winPercentage;

        // When the game is restarted, a new game occurs starting with this outer loop
        // The current game number increases by one everytime a new game occurs
        while (gamePlay) {
            num += 1;
            System.out.println("START GAME #" + num);
            handValue = 0;
            menuOptions = true;
            cardNumber = rand.nextInt(13) + 1;

            // Random value is generated and that value is outputted as the player's card number
            if (cardNumber == 1) {
                System.out.println("\nYour card is a ACE!");
                handValue += cardNumber;
            } else if (cardNumber > 1 && cardNumber < 11) {
                System.out.println("\nYour card is a " + cardNumber + "!");
                handValue += cardNumber;
            } else if (cardNumber == 11) {
                System.out.println("\nYour card is a JACK!");
                handValue += 10;
            } else if (cardNumber == 12) {
                System.out.println("\nYour card is a QUEEN!");
                handValue += 10;
            } else if (cardNumber == 13) {
                System.out.println("\nYour card is a KING!");
                handValue += 10;
            }
            // prints out the hand value of the player as defined by handValue += cardNumber or handValue += 10
            System.out.println("Your hand is: " + handValue);

            // continues the game after the first randomly generated number occurs and displays options that the player can choose from
            while (menuOptions) {
                System.out.println("\n1. Get another card ");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.print("\nChoose an option: ");

                // Allows input from player to choose an option (must be an integer input)
                int userInput = scanner.nextInt();

                // Random card number is generated and printed again, and the new player hand value is added to the previous player hand value
                if (userInput == 1) {
                    cardNumber = rand.nextInt(13) + 1;
                    if (cardNumber == 1) {
                        System.out.println("\nYour card is a ACE!");
                        handValue += cardNumber;
                    } else if (cardNumber > 1 && cardNumber < 11) {
                        System.out.println("\nYour card is a " + cardNumber + "!");
                        handValue += cardNumber;
                    } else if (cardNumber == 11) {
                        System.out.println("\nYour card is an JACK!");
                        handValue += 10;
                    } else if (cardNumber == 12) {
                        System.out.println("\nYour card is a QUEEN!");
                        handValue += 10;
                    } else if (cardNumber == 13) {
                        System.out.println("\nYour card is a KING!");
                        handValue += 10;
                    }
                    // prints out updated player hand value
                    System.out.println("Your hand is: " + handValue);


                    /*
                    Resets the game if player hand value is equal to 21 (player wins) or greater than 21 (player loses).
                    The number of games won is increased by one if the player wins.
                    The number of games lost is increased by one if the player loses.
                    The number of total games played is increased by one if the player wins or loses.
                    If the player hand value is less than 21, then the menu options are displayed again.
                    */
                    if (handValue == 21) {
                        System.out.println("\nBLACKJACK! You win!\n");
                        playerWins += 1;
                        totalGames += 1;
                        // Starts a new game
                        menuOptions = false;
                    } else if (handValue > 21) {
                        System.out.println("\nYou exceeded 21! You lose.\n");
                        dealerWins += 1;
                        totalGames += 1;
                        // Starts a new game
                        menuOptions = false;
                    }
                }
                // Compares current player hand value to the dealer's hand value (randomly generated) to determine if the player wins, loses, or ties
                // The number of player wins, dealer wins, tied games, and total games played are updated depending on the comparison
                else if (userInput == 2) {
                    int dealerValue = rand.nextInt(11) + 16;
                    System.out.println("\nDealer's hand: " + dealerValue);
                    System.out.println("Your hand is: " + handValue);

                    // Determines who wins or if it's a tie
                    if (dealerValue > 21 && handValue <= 21) {
                        System.out.println("\nYou win!\n");
                        playerWins += 1;
                    } else if (dealerValue == handValue) {
                        System.out.println("\nIt's a tie! No one wins!\n");
                        tiedGames += 1;
                    } else if (dealerValue > 21 && handValue > dealerValue) {
                        System.out.println("\nYou win!\n");
                        playerWins += 1;
                    } else if (dealerValue <= 21 && handValue > 21) {
                        System.out.println("\nDealer wins!\n");
                        dealerWins += 1;
                    } else if (dealerValue <= 21 && dealerValue > handValue) {
                        System.out.println("\nDealer wins!\n");
                        dealerWins += 1;
                    }
                    totalGames += 1;
                    // Starts a new game
                    menuOptions = false;
                }
                // Prints the statistical record of previous games (not including the current game) and then displays the options
                else if (userInput == 3) {
                    System.out.println("\nNumber of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tiedGames);
                    System.out.println("Total # of games played is: " + totalGames);

                    winPercentage = ((double) playerWins) / (totalGames) * 100;
                    System.out.println("Percentage of Player wins: " + winPercentage + "%");
                }
                // Exits the program entirely and the game is ended
                else if (userInput == 4) {
                    menuOptions = false;
                    gamePlay = false;
                }
                // Prompts the player to enter a valid input to continue playing the game
                else {
                    System.out.println("\nInvalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                }
            }
        }
    }
}