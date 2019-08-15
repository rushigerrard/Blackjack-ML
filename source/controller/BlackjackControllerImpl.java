package controller;

import java.util.List;

import model.BlackjackHand;
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
	
	public Integer getBet() {
		return bet;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	BlackjackControllerImpl(Integer bet) {
		this.bet = bet;
	}

	public BlackjackControllerImpl() {
		blackJackService = new BlackjackServiceImpl();
	}
	
	@Override
	public List<Integer> hit() {
		return blackJackService.hit();
	}

	@Override
	public void stand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doubleDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BlackjackHand> split() {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Integer> getHandValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
