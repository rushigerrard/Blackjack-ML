package test;

import agent.DealerAgent;
import agent.PlayerAgent;
import controller.BlackjackController;
import model.BlackjackGame;
import model.BoardState;
import model.Hand;

public class TrialGame {

	public static void main(String[] args) {
		BlackjackGame blackJackGame = new BlackjackGame();

		PlayerAgent playerAgent = (PlayerAgent) blackJackGame.getPlayerAgent();
		DealerAgent dealerAgent = (DealerAgent) blackJackGame.getDealerAgent();

		BlackjackController playerController = playerAgent.getController();
		BlackjackController dealerController = dealerAgent.getController();

		/**
		 * Step 1 Dealer and player both draw a card. Ideally both draw 2 cards
		 * But one of dealer card is hidden
		 *
		 */
		playerController.startNewHand();
		dealerController.startNewHand();
		Hand playerHand = playerController.hit();
		Hand dealerHand = dealerController.hit();

		Integer playerScore = playerHand.getBlackjackValue().get(0);
		Integer dealerScore = dealerHand.getBlackjackValue().get(0);
		System.out.println(playerScore + " , " + dealerScore);
		/**
		 * Step 2 Player keeps on playing based on the ML engine output
		 */

		BoardState state = new BoardState();
		state.setDealerHand(dealerHand);
		state.setDealerScore(dealerScore);
		state.setPlayerHand(playerHand);
		state.setPlayerScore(playerScore);
		while (playerAgent.makeADecision(state) == 0) {// Let 0 = hit
			state = playARound(playerController, state);
		}

	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState playARound(BlackjackController playerController, BoardState state) {
		Hand playerHand = playerController.hit();
		state.setPlayerHand(playerHand);
		return state;

	}
}
