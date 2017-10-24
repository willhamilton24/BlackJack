import java.util.Scanner;

public class BlackJack
{
    private Player player;
    private Dealer dealer;

	public BlackJack()
	{

	}

    //play a game of blackjack with one player and one dealer
	public void playGame()
	{
	    // Set Up
		Scanner keyboard = new Scanner(System.in);
        player = new Player();
        dealer = new Dealer();
        int winner;
        // ++ Deal ++

        boolean playing = true;
        while (playing == true) {
            winner = 2;
            // Dealer's Cards
            for (int d = 0; d != 2; d++) {
                dealer.addCardToHand(dealer.dealCard());
            }
            System.out.println("Dealer is showing a " + dealer.hand[1].toString());

            // Player's Cards
            for (int d = 0; d != 2; d++) {
                player.addCardToHand(dealer.dealCard());
            }
            System.out.println("You have a " + player.hand[0].toString() + " and a " + player.hand[1].toString());

            // ++ Player's Turn ++
            boolean playerActive = true;
            while (playerActive == true) {
                System.out.print("Hand Value: " + player.getHandValue() + " Hit or Stay? ");
                String move = keyboard.next();
                if (move.equals("hit")) {
                    player.addCardToHand(dealer.dealCard());
                } else if (move.equals("stay")) {
                    playerActive = false;
                } else if (player.getHandValue() > 21) {
                    System.out.println("Player Busts!");
                    winner = 1;
                } else {
                    System.out.println("Move Not Recognized");
                }
            }
            System.out.println("Player's Hand Value: " + player.getHandValue());

            // ++ Dealer's Turn ++
            boolean dealerActive = true;
            while (dealerActive == true) {
                if (dealer.getHandValue() < 16) {
                    dealer.addCardToHand(dealer.dealCard());
                } else if (dealer.getHandValue() > 21) {
                    System.out.println("Dealer Busts!");
                    winner = 0;
                } else {
                    dealerActive = false;
                }
            }
            System.out.println("Dealer's Hand Value: " + dealer.getHandValue());


            // ++ Comparison / End ++
            if (player.getHandValue() > dealer.getHandValue() || winner == 0) {
                System.out.println("Player Wins!");
                player.countWin();
                System.out.println("Player has " + player.getWinCount() + " wins");
            } else if (player.getHandValue() < dealer.getHandValue() || winner == 1) {
                System.out.println("Dealer Wins!");
                dealer.countWin();
                System.out.println("Dealer has " + dealer.getWinCount() + " wins");
            } else {
                System.out.println("Push!");
            }

            // Play Again?
            System.out.println("Play Again?");
            String playAgain = keyboard.next().toLowerCase();
            boolean playAgainValid = false;
            while (playAgainValid == false) {
                if (playAgain == "no") {
                    playing = false;
                    playAgainValid = true;
                } else if (playAgain == "yes") {
                    playAgainValid = true;
                } else {
                    System.out.println("Invalid Response: Please enter yes or no");
                }
            }
        }
    }
	
	public static void main(String[] args)
	{
        BlackJack game = new BlackJack();
		game.playGame();
	}
}