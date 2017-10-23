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
        // ++ Deal ++

        // Dealer's Cards
        for (int d = 0; d != 2; d++) {dealer.addCardToHand(dealer.dealCard());}
        System.out.println("Dealer is showing a " + dealer.hand[1].toString());

        // Player's Cards
        for (int d = 0; d != 2; d++) {player.addCardToHand(dealer.dealCard());}
        System.out.println("You have a " + player.hand[0].toString() + " and a " + player.hand[1].toString());

        // ++ Player's Turn ++

        // ++ Dealer's Turn ++

        // ++ Comparison / End ++

    }
	
	public static void main(String[] args)
	{
        BlackJack game = new BlackJack();
		game.playGame();
	}
}