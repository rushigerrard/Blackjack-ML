package controller;

import java.util.List;

import model.BlackjackHand;

/**
 * The APIs for playing a game of blackjack are defined in this controller.
 * Agents will use an implementation of this controller to play the game.
 * 
 * @author rushikesh
 *
 */
public interface BlackjackController {

	Integer getBet();

	void setBet(Integer bet);

	List<Integer> hit();
	
	void stand();

	void doubleDown();

	List<BlackjackHand> split();

	List<Integer> getHandValue();
}
