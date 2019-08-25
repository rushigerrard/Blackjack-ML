package agent;

import java.util.List;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;
import model.BoardState;
import model.Deck;
import model.Hand;

/**
 * Dealer agent will use a basic strategy for making a decision
 * 
 * @author rushikesh
 *
 */
public class DealerAgent implements BlackjackAgent {

	public BlackjackController getController() {
		return controller;
	}

	public void setController(BlackjackController controller) {
		this.controller = controller;
	}

	private BlackjackController controller;

	@Override
	public int makeADecision(BoardState state) {
		Hand dealerHand = state.getDealerHand();
		int dealerScore = dealerHand.getBlackjackValue().get(0);
		state.setDealerScore(dealerScore);
		if (dealerScore <= 16) {
			return 0;
		} else if (dealerScore <= 21) {
			return 1;
		} else {
			return 1;
		}
	}

	public DealerAgent(Deck deck) {
		controller = new BlackjackControllerImpl(deck);
	}

	@Override
	public void clearHand() {
		controller.clearHand();
	}

	@Override
	public Hand startNewHand() {
		return controller.startNewHand();
	}

	@Override
	public Integer getBet() {
		return controller.getBet();
	}

	@Override
	public void setBet(Integer bet) {
		controller.setBet(bet);
	}

	@Override
	public Hand hit() {
		return controller.hit();
	}

	@Override
	public void stand() {
		controller.stand();
	}

	@Override
	public void doubleDown() {
		controller.doubleDown();
	}

	@Override
	public List<Hand> split() {
		return controller.split();
	}

	@Override
	public List<Integer> getHandValue() {
		return controller.getHandValue();
	}
}
