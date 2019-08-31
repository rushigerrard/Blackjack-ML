package Blackjack_Agent.Blackjack;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Card;
import model.Card.Suit;
import model.Hand;

public class HandValueTest extends TestCase {

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public HandValueTest(String testName)
    {
        super( testName );
    }

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(HandValueTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Hand hand = new Hand();
		Card eightHeart = new Card(10, Suit.HEARTS);
		Card aceClub = new Card(1, Suit.CLUBS);
		Card aceDiamond = new Card(1, Suit.DIAMONDS);

		System.out.println("Add 8 of hearts");
		hand.addCard(eightHeart);
		List<Integer> handList = hand.getBlackjackValue();
		assertEquals(handList.size(), 1);

		System.out.println("Add ace of clubs");
		hand.addCard(aceClub);
		handList = hand.getBlackjackValue();
		System.out.println("Possible hand values : " + handList.get(0) + " , " + handList.get(1));
		assertEquals(handList.get(0), new Integer(11));
		assertEquals(handList.get(1), new Integer(21));

		System.out.println("Added ace of diamonds");
		hand.addCard(aceDiamond);
		handList = hand.getBlackjackValue();
		assertEquals(handList.get(0), new Integer(12));
		System.out.println("Possible hand values : " + handList.get(0));

	}
}
