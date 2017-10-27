import java.util.Arrays;

public class Player {

    /*
     * ++ Instance Variables++
     */

    public Card[] hand = new Card[11];
    public int winCount = 0;
    public int nextIndex = 0;



    //return the number of cards in hand
    public int getHandSize()
    {
        boolean hasCard = true;
        int x = 0;
        int cards = 0;
        while (hasCard == true) {
            if (hand[x] != null) {
                cards++;
            } else {
                hasCard = false;
            }
            x++;
        }
        return cards;
    }

    /*
     * ++ Constructor ++
     */

    public Player() {

    }

    /*
     *  ++ Methods ++
     */


    //increment the player's win count
    public void countWin()
    {
        winCount++;
    }

    //return this player's win count
    public int getWinCount()
    {
        return winCount;
    }

    //compute the value of
    public int getHandValue()
    {
        int total = 0;
        for (int x = 0; x < getHandSize(); x++) {
            total += hand[x].getValue();
        }

        return total;
    }

    //"discard" the Player's hand when a new round begins
    public  void resetHand() {
        for (int x = 0; x <= 10; x++) {
            hand[x] = null;
            nextIndex = 0;
        }
    }

    //add temp to this player's hand
    public void addCardToHand( Card temp )
    {
        hand[nextIndex] = temp;
        nextIndex++;
    }

    public String toString()
    {
        return "hand = " + Arrays.toString(hand) + " \n-  # wins " + winCount;
    }
}
