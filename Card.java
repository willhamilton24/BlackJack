public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private int suit;
	private int face;

  	//constructors
    public Card(int s, int f)
    {
        suit = s;
        face = f;
    }
    
    //return the blackjack value for the card
    //(2-10 for number cards, 10 for jack/queen/king, 11 for ace
    public int getValue()
    {
        // ACCOUNT FOR ACE
        if (face < 11 && face > 1) {
            return face;
        } else if (face == 1) {
            return 11;
        } else {
            return 10;
        }
    }


  	public String toString() {
        return FACES[face];
    }
  	
 }