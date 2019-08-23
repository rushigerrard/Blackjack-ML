package agent;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;
import model.BoardState;
import model.Deck;

/**
 * Player agent will use ML based strategies for making a decision
 * 
 * @author rushikesh
 *
 */
public class PlayerAgent implements BlackjackAgent {

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public BlackjackController getController() {
		return controller;
	}

	public void setController(BlackjackController controller) {
		this.controller = controller;
	}
	private int earning = 1000000;

	private int bet = 100;

	private BlackjackController controller;

	public PlayerAgent(Deck deck) {
		controller = new BlackjackControllerImpl(deck);
	}
	@Override
	public int makeADecision(BoardState state) {
		// TODO Auto-generated method stub
		return 0;
	}


}
