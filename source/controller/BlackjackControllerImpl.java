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

	private Integer bet;
	
	private Hand hand;
	
	public void clearHand() {
		hand = null;
	}

	public Hand startNewHand() {
		hand = new Hand();
		return hand;
	}
	public Integer getBet() {
		return bet;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	BlackjackControllerImpl(Integer bet) {
		this.bet = bet;
	}

	public BlackjackControllerImpl(Deck deck) {
		blackJackService = new BlackjackServiceImpl(deck);
	}
	
	@Override
	public Hand hit() {
		hand.addCard(blackJackService.hit());
		return hand;
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

}
