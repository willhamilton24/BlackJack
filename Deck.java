import java.util.Arrays;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public int topCardIndex = 0;
	public Card[] stack;

		//instance variables
		public Card[] cards;

		//constructor
		public Deck()
		{
			cards = new Card[52];

			int i = 0;

			for(int s = 0;s < 4;s++)
			{
				for(int v = 1;v <= 13; v++)
				{
					cards[i] = new Card(s,v);
					i++;
				}
			}
			shuffle();
		}

		public void shuffle()
		{
//mix up cards
			for(int i=0;i < 52;i++)
			{
				int rand1 = (int)(Math.random() * cards.length);
				int rand2 = (int)(Math.random() * cards.length);

				Card tmp = cards[rand1];
				cards[rand1] = cards[rand2];
				cards[rand2] = tmp;
			}
		}

		public String toString() {
            String out = "";

            for (int i = 0; i < cards.length; i++) {
                out = out + cards[i] + "\n";
            }

            return out;
        }
}