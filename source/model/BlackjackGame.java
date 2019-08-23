package model;

/**
 * BlackjackGame is the base class from which the game starts
 * It contains the player and dealer agents
 * The number of pack of cards
 * @author rushikesh
 *
 */
import agent.BlackjackAgent;
import agent.DealerAgent;
import agent.PlayerAgent;
public class BlackjackGame {
	
	private BlackjackAgent playerAgent;
	private BlackjackAgent dealerAgent;
	private Deck deck;

	public BlackjackGame() {
		deck = new Deck();
		deck.shuffle();
		playerAgent = new PlayerAgent(deck);
		dealerAgent = new DealerAgent(deck);
	}

	public BlackjackAgent getDealerAgent() {
		return dealerAgent;
	}

	public void setDealerAgent(BlackjackAgent dealerAgent) {
		this.dealerAgent = dealerAgent;
	}

	public BlackjackAgent getPlayerAgent() {
		return playerAgent;
	}

	public void setPlayerAgent(BlackjackAgent playerAgent) {
		this.playerAgent = playerAgent;
	}

	public Deck getDeck() {
		return deck;
	}
}
