import java.util.Arrays;

public class Dealer extends Player
{

    public Deck deckOfCards = new Deck();
    public int topCardIndex = 0;

	//shuffle the deck
    public void shuffleDeck()
    {
        deckOfCards.shuffle();
    }

	//get the next card from the deckOfCards and return it
    public Card dealCard()
    {
        topCardIndex++;
        return deckOfCards.cards[topCardIndex];

    }


    //return true if the dealer hits, false if not
	public boolean hit()
	{
        if (getHandValue() < 16) {
            return true;
        } else {
            return false;
        }
	}
}