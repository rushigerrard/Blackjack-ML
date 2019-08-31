package agent;

import java.util.List;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;
import model.BoardState;
import model.Decision;
import model.Deck;
import model.Hand;
import strategy.MLStrategy;

/**
 * Player agent will use ML based strategies for making a decision
 * 
 * @author rushikesh
 *
 */
public class PlayerAgent implements BlackjackAgent {

	private int earning = 0;

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
	public Decision makeADecision(BoardState state) {
		return mlStrategy.makeADecision(state);
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
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
