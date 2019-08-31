package controller;

import java.util.List;

import model.Hand;

/**
 * The APIs for playing a game of blackjack are defined in this controller.
 * Agents will use an implementation of this controller to play the game.
 * 
 * @author rushikesh
 *
 */
public interface BlackjackController {

	void clearHand();

	Hand startNewHand();

	Integer getBet();

	void setBet(Integer bet);

	Hand hit();
	
	void stand();

	void doubleDown();

	List<Hand> split();

	List<Integer> getHandValue();

	void shuffle();

	boolean isDeckShort();
}
