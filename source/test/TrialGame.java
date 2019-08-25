package test;

import agent.DealerAgent;
import agent.PlayerAgent;
import controller.BlackjackController;
import model.BlackjackGame;
import model.BoardState;
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
		// Step 4 - Instantiate the controllers
		BlackjackController playerController = playerAgent.getController();
		BlackjackController dealerController = dealerAgent.getController();
		/**
		 * Step 5 Dealer and player both draw a card. Ideally both draw 2 cards
		 * But one of dealer card is hidden
		 *
		 */
		playerController.startNewHand();
		dealerController.startNewHand();
		Hand playerHand = playerController.hit();
		Hand dealerHand = dealerController.hit();

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

		while (playerAgent.makeADecision(state) == 0) {// Let 0 = hit
			state = playerPlaysARound(playerController, state);
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
			playerAgent.decrementEarning();
		} else {
			System.out.println("Dealer plays next");
			while (dealerAgent.makeADecision(state) == 0) {
				state = dealerPlaysARound(dealerController, state);
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
	private static BoardState playerPlaysARound(BlackjackController playerController, BoardState state) {
		Hand playerHand = playerController.hit();
		System.out.println("Player hand is :" + playerHand.toString());
		state.setPlayerHand(playerHand);
		return state;
	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState dealerPlaysARound(BlackjackController dealerController, BoardState state) {
		Hand playerHand = dealerController.hit();
		System.out.println("Player hand is :" + playerHand.toString());
		state.setDealerHand(playerHand);
		return state;
	}
}
