package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An object of type Hand represents a hand of cards.  The maximum number of
 * cards in the hand can be specified in the constructor, but by default is 5.
 *   
 * A utility function is provided for computing the value of the hand in the game 
 * of Blackjack. It is getBlackjackHand(), which returns the value of the hand 
 * for the game of Blackjack.
*/

import java.util.Vector;

public class Hand {

	private Vector<Card> hand; // The cards in the hand.

	public Hand() {
		// Create a Hand object that is initially empty.
		hand = new Vector<Card>();
	}

	public void clear() {
		// Discard all the cards from the hand.
		hand.removeAllElements();
	}

	public void addCard(Card c) {
		// Add the card c to the hand. c should be non-null. (If c is
		// null, nothing is added to the hand.)
		if (c != null)
			hand.addElement(c);
	}

	public void removeCard(Card c) {
		// If the specified card is in the hand, it is removed.
		hand.removeElement(c);
	}

	public void removeCard(int position) {
		// If the specified position is a valid position in the hand,
		// then the card in that position is removed.
		if (position >= 0 && position < hand.size())
			hand.removeElementAt(position);
	}

	public int getCardCount() {
		// Return the number of cards in the hand.
		return hand.size();
	}

	public Card getCard(int position) {
		// Get the card from the hand in given position, where positions
		// are numbered starting from 0. If the specified position is
		// not the position number of a card in the hand, then null
		// is returned.
		if (position >= 0 && position < hand.size())
			return (Card) hand.elementAt(position);
		else
			return null;
	}

	public List<Integer> getBlackjackValue() {
		// Returns the value of this hand for the
		// game of Blackjack.

		List<Integer> valueList = new ArrayList<>();
		int val; // The value computed for the hand.
		boolean ace; // This will be set to true if the
						// hand contains an ace.
		int cards; // Number of cards in the hand.

		val = 0;
		ace = false;
		cards = getCardCount();

		for (int i = 0; i < cards; i++) {
			// Add the value of the i-th card in the hand.
			Card card; // The i-th card;
			int cardVal; // The blackjack value of the i-th card.
			card = getCard(i);
			cardVal = card.getValue(); // The normal value, 1 to 13.
			if (cardVal > 10) {
				cardVal = 10; // For a Jack, Queen, or King.
			}
			if (cardVal == 1) {
				ace = true; // There is at least one ace.
			}
			val = val + cardVal;
		}
		valueList.add(val);

		// Now, val is the value of the hand, counting any ace as 1.
		// If there is an ace, and if changing its value from 1 to
		// 11 would leave the score less than or equal to 21,
		// then do so by adding the extra 10 points to val.
		if (ace == true && val + 10 <= 21) {
			val = val + 10;
			valueList.add(val);
		}
		return valueList;
	} // end getBlackjackValue()

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Card c : hand) {
			sb.append(c.toString()).append(" , ");
		}

		return sb.toString();

	}
}