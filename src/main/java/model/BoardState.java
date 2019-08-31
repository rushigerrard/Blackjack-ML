package model;

import java.util.List;

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

	public List<Integer> getDealerScore() {
		return dealerScoreList;
	}

	public void setDealerScore(List<Integer> dealerScoreList) {
		this.dealerScoreList = dealerScoreList;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public List<Integer> getPlayerScore() {
		return playerScoreList;
	}

	public void setPlayerScore(List<Integer> playerScoreList) {
		this.playerScoreList = playerScoreList;
	}

	private Hand dealerHand;

	private List<Integer> dealerScoreList;

	private Hand playerHand;

	private List<Integer> playerScoreList;

}
