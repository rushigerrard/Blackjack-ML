package model;

/**
 * BoardState gives the current state of a blackjack board The blackjack game
 * 
 * @author rushikesh
 *
 */
public class BoardState {

	public Hand getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(Hand dealerHand) {
		this.dealerHand = dealerHand;
	}

	public int getDealerScore() {
		return dealerScore;
	}

	public void setDealerScore(int dealerScore) {
		this.dealerScore = dealerScore;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	private Hand dealerHand;

	private int dealerScore;

	private Hand playerHand;

	private int playerScore;

}
