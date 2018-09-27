package Blackjack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Blackjack {

    int gameNumber = 0;
    int playerHandValue = 0;
    int dealersHandValue = 0;
    int playerWins = 0;
    int dealerWins = 0;
    int numberOfTies = 0;
    int option = 1;
    int gamesPlayed = 0;

    P1Random rn = new P1Random();

    public int randomNumber(int lowerLimit, int upperLimit) {
        return rn.nextInt(upperLimit) + lowerLimit;
    }

    public int cardValue(int playerCard) {
        if (playerCard == 11 || playerCard == 12 || playerCard == 13) {
            return 10;
        } else {
            return playerCard;
        }
    }

    public void printCardValue(int playerCard) {
        switch (playerCard) {
            case 1:
                System.out.println("Your card is a ACE!");
                break;
            case 11:
                System.out.println("Your card is a JACK!");
                break;
            case 12:
                System.out.println("Your card is a QUEEN!");
                break;
            case 13:
                System.out.println("Your card is a KING!");
                break;
            default:
                System.out.println("Your card is a " + playerCard + "!");
                break;
        }
    }

    public void dealCards() {

        int playerCard = this.randomNumber(1, 13);

        // corresponding value based for the random number generated
        int playerCardValue = this.cardValue(playerCard);

        this.printCardValue(playerCard);

        // increment the player hand value through the iterations
        this.playerHandValue += playerCardValue;

        // print the total value of the hand
        System.out.println("Your hand is: " + this.playerHandValue + "\n");

    }


    public static void main(String[] args) {
        Blackjack bjn = new Blackjack();
        boolean exitProgram = false;
        Scanner reader = new Scanner(System.in);

        while (!exitProgram) {
            bjn.option = 1;
            bjn.playerHandValue = 0;
            bjn.dealersHandValue = 0;

            if (bjn.gameNumber +1  == 7) {
                break;
            }
            System.out.println("START GAME #" + ++bjn.gameNumber + "\n");



            whileLoop: while (true) {

                switch (bjn.option) {
                    case 1:
                        bjn.dealCards();

                        if (bjn.playerHandValue == 21) {
                            bjn.playerWins++;
                            System.out.println("BLACKJACK! You win! \n");
                            bjn.gamesPlayed++;
                            break whileLoop;
                        } else if (bjn.playerHandValue > 21) {
                            bjn.dealerWins++;
                            System.out.println("You exceeded 21! You lose. \n");
                            bjn.gamesPlayed++;
                            break whileLoop;
                        }
                        break;

                    case 2:
                        // generate the dealers random number
                        bjn.dealersHandValue = bjn.randomNumber(16, 11);

                        System.out.println("Dealer's hand: " + bjn.dealersHandValue);
                        System.out.println("Your hand is: " + bjn.playerHandValue + "\n");


                        if (bjn.dealersHandValue > 21) {
                            bjn.playerWins++;
                            System.out.println("You win!");
                        } else if (bjn.dealersHandValue == bjn.playerHandValue) {
                            bjn.numberOfTies++;
                            System.out.println("It's a tie! No one wins!");
                        } else if (bjn.dealersHandValue > bjn.playerHandValue) {
                            bjn.dealerWins++;
                            System.out.println("Dealer wins!");
                        } else {
                            bjn.playerWins++;
                            System.out.println("You win!");
                        }
                        bjn.gamesPlayed++;
                        System.out.println();
                        break whileLoop;

                    case 3:

                        // convert the integer number to float
                        float percentageWins = ((float)bjn.playerWins / (float)bjn.gamesPlayed) * 100;

                        DecimalFormat dec = new DecimalFormat("0.0");

                        // Print the statistics of the game
                        System.out.println("Number of Player wins: " + bjn.playerWins);
                        System.out.println("Number of Dealer wins: " + bjn.dealerWins);
                        System.out.println("Number of tie games: " + bjn.numberOfTies);
                        System.out.println("Total # of games played is: " + bjn.gamesPlayed);
                        System.out.println("Percentage of Player wins: " + dec.format(percentageWins) + "% \n");
                        break;

                    case 4:
                        // Exit the program
                        exitProgram = true;
                        break whileLoop;

                    default:
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4. \n");
                        break;
                }

                // After the card is dealt print the menu to the screen
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit \n");
                System.out.print("Choose an option: ");
                bjn.option = reader.nextInt();
                System.out.println();
            }
        }
    }
}
