package application;

import model.Card;
import model.Card.Suit;
import model.Hand;

/**
 * Hello world!
 *
 */
public class MonitorBoardState 
{
    public static void main( String[] args )
    {
		Hand hand = new Hand();
		Card aceClub = new Card(1, Suit.CLUBS);
		Card aceDiamond = new Card(1, Suit.DIAMONDS);
		hand.addCard(aceClub);
		System.out.println("When hand contains just an ace, possible values are : ");
		for (Integer possibleValue : hand.getBlackjackValue()) {
			System.out.println(possibleValue);
		}
		hand.addCard(aceDiamond);
		System.out.println("When hand contains 2 aces, possible values are : ");
		for (Integer possibleValue : hand.getBlackjackValue()) {
			System.out.println(possibleValue);
		}


    }
}
