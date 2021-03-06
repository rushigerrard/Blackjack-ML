package service;

import java.util.List;

import model.Hand;

/**
 * BlackjackService provides the business logic for processing a user actions
 * 
 * For example, on stand, the dealer starts playing on hit, a card is added to
 * user's hand, the user can go bust through it on split, a hand is split into 2
 * on doubledown, the bets for a hand are doubled
 *
 * @author rushikesh
 *
 */
public interface BlackjackService {

	Integer getBet();

	void setBet(Integer bet);

	Hand hit();

	void stand();

	void doubleDown();

	List<Hand> split();

	List<Integer> getHandValue();

	void shuffle();

	void clearHand();

	Hand startNewHand();

	boolean isDeckShort();
}
