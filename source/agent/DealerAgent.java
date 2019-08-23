package agent;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;
import model.BoardState;
import model.Deck;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public DealerAgent(Deck deck) {
		controller = new BlackjackControllerImpl(deck);
	}
}
