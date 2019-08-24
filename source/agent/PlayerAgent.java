package agent;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;
import model.BoardState;
import model.Deck;
import strategy.MLStrategy;

/**
 * Player agent will use ML based strategies for making a decision
 * 
 * @author rushikesh
 *
 */
public class PlayerAgent implements BlackjackAgent {

	private int earning = 1000000;

	private int bet = 100;

	private BlackjackController controller;

	private MLStrategy mlStrategy;

	public void setMlStrategy(MLStrategy mlStrategy) {
		this.mlStrategy = mlStrategy;
	}

	public PlayerAgent(Deck deck) {
		controller = new BlackjackControllerImpl(deck);
	}

	@Override
	public int makeADecision(BoardState state) {
		return mlStrategy.makeADecision(state);
	}

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

	public void incrementEarning() {
		earning = earning + bet;
	}

	public void decrementEarning() {
		earning = earning - bet;
	}


}
