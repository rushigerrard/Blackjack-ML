package controller;

import java.util.List;

import model.Deck;
import model.Hand;
import service.BlackjackService;
import service.BlackjackServiceImpl;

/**
 * Default implementation of BlackjackController.
 * 
 * @author rushikesh
 *
 */
public class BlackjackControllerImpl implements BlackjackController {

	private BlackjackService blackJackService;

	// private Integer bet;
	
	// private Hand hand;
	
	public void clearHand() {
		blackJackService.clearHand();
	}

	public Hand startNewHand() {
		return blackJackService.startNewHand();
	}


	public BlackjackControllerImpl(Deck deck) {
		blackJackService = new BlackjackServiceImpl(deck);
	}
	
	@Override
	public Hand hit() {
		return blackJackService.hit();
	}

	@Override
	public void stand() {

	}

	@Override
	public void doubleDown() {

	}

	@Override
	public List<Hand> split() {
		return null;

	}

	@Override
	public List<Integer> getHandValue() {
		return null;
	}

	@Override
	public void shuffle() {
		blackJackService.shuffle();
	}

	@Override
	public Integer getBet() {

		return null;
	}

	@Override
	public void setBet(Integer bet) {

	}

	@Override
	public boolean isDeckShort() {
		return blackJackService.isDeckShort();
	}

}
