package test;

import agent.BlackjackAgent;
import agent.DealerAgent;
import agent.PlayerAgent;
import model.BlackjackGame;
import model.BoardState;
import model.Decision;
import model.Hand;
import strategy.BasicStrategy;

public class TrialGame {

	public static void main(String[] args) {

		System.out.println("Start game");
		// Step 1 - Instantiate a game instance
		BlackjackGame blackJackGame = new BlackjackGame();
		// Step 2 - Instantiate player agents
		PlayerAgent playerAgent = (PlayerAgent) blackJackGame.getPlayerAgent();
		DealerAgent dealerAgent = (DealerAgent) blackJackGame.getDealerAgent();
		// Step 3 - Set their ML strategy
		playerAgent.setMlStrategy(new BasicStrategy());
		/**
		 * Step 4 Dealer and player both draw a card. Ideally both draw 2 cards
		 * But one of dealer card is hidden
		 *
		 */
		playerAgent.startNewHand();
		dealerAgent.startNewHand();
		Hand playerHand = playerAgent.hit();
		Hand dealerHand = dealerAgent.hit();

		Integer playerScore = playerHand.getBlackjackValue().get(0);
		Integer dealerScore = dealerHand.getBlackjackValue().get(0);
		/**
		 * Step 6 Player keeps on playing based on the ML engine output
		 */
		BoardState state = new BoardState();
		state.setDealerHand(dealerHand);
		state.setDealerScore(dealerScore);
		state.setPlayerHand(playerHand);
		state.setPlayerScore(playerScore);

		while (playerAgent.makeADecision(state) == Decision.HIT) {
			state = playerPlaysARound(playerAgent, state);
		}
		playerScore = state.getPlayerScore();
		System.out.println("Player stands at hand value " + playerScore);
		// Step 7 - Check if a player has hit blackjack
		// TODO : Perfect blackjack only with 2 cards? Please check.
		if (playerScore == 21) {
			System.out.println("BLACKJACK! Player wins.");
			playerAgent.incrementEarning();
		} else if (playerScore > 21) {
			System.out.println("Player goes BUST.");
			System.out.println("Dealer wins");
			playerAgent.decrementEarning();
		} else {
			System.out.println("Dealer plays next");
			while (dealerAgent.makeADecision(state) == Decision.HIT) {
				state = dealerPlaysARound(dealerAgent, state);
			}
			dealerScore = state.getDealerScore();
			System.out.println("Dealer stopped at hand value " + dealerScore);
			if (dealerScore > 21) {
				System.out.println("Dealer goes BUST.");
			} else if (dealerScore < playerScore) {
				System.out.println("Player wins");
				playerAgent.incrementEarning();
			} else {
				System.out.println("Dealer wins");
				playerAgent.decrementEarning();
			}
		}
	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState playerPlaysARound(BlackjackAgent playerAgent, BoardState state) {
		Hand playerHand = playerAgent.hit();
		System.out.println("Player hand is :" + playerHand.toString());
		state.setPlayerHand(playerHand);
		return state;
	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState dealerPlaysARound(BlackjackAgent dealerAgent, BoardState state) {
		Hand playerHand = dealerAgent.hit();
		System.out.println("Player hand is :" + playerHand.toString());
		state.setDealerHand(playerHand);
		return state;
	}
}
