package application;

import agent.BlackjackAgent;
import agent.DealerAgent;
import agent.PlayerAgent;
import model.BlackjackGame;
import model.BoardState;
import model.Decision;
import model.Hand;
import strategy.MLStrategy;
import strategy.JythonObjectFactory;

public class TrialGame_Random {

	public static void main(String[] args) {

		System.out.println("Start game");
		// Step 1 - Instantiate a game instance
		BlackjackGame blackJackGame = new BlackjackGame();
		// Step 2 - Instantiate player agents
		PlayerAgent playerAgent = (PlayerAgent) blackJackGame.getPlayerAgent();
		DealerAgent dealerAgent = (DealerAgent) blackJackGame.getDealerAgent();
		// Step 3 - Set their ML strategy
		JythonObjectFactory factory = JythonObjectFactory.getInstance();
		MLStrategy strategy = (MLStrategy) factory.createObject(MLStrategy.class, "RandomStrategy");
		playerAgent.setMlStrategy(strategy);

		int totalRounds = 10;
		if (args.length > 0) {
			totalRounds = Integer.parseInt(args[0]);
		}

		int round = 0;
		while (round < totalRounds) {
			round++;
			/**
			 * Step 4 Dealer and player both draw a card. Ideally both draw 2
			 * cards But one of dealer card is hidden
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
			state.setPlayerHand(playerHand);
			state.setPlayerScore(playerHand.getBlackjackValue());

			while (playerAgent.makeADecision(state) == Decision.HIT) {
				state = playerPlaysARound(playerAgent, state);
			}
			playerScore = state.getPlayerScore().get(0);
			// System.out.println("Player stands at hand value " + playerScore);
			// Step 7 - Check if a player has hit blackjack
			// TODO : Perfect blackjack only with 2 cards? Please check.
			if (playerScore == 21) {
				// System.out.println("BLACKJACK! Player wins.");
				playerAgent.incrementEarning();
			} else if (playerScore > 21) {
				// System.out.println("Player goes BUST.");
				System.out.println("Dealer wins");
				playerAgent.decrementEarning();
			} else {
				// System.out.println("Dealer plays next");
				while (dealerAgent.makeADecision(state) == Decision.HIT) {
					state = dealerPlaysARound(dealerAgent, state);
				}
				dealerScore = state.getDealerScore().get(0);
				// System.out.println("Dealer stopped at hand value " +
				// dealerScore);
				if (dealerScore > 21) {
					// System.out.println("Dealer goes BUST.");
					System.out.println("Player wins");
					playerAgent.incrementEarning();
				} else if (dealerScore < playerScore) {
					System.out.println("Player wins");
					playerAgent.incrementEarning();
				} else if (dealerScore == playerScore) {
					System.out.println("Player and dealer score matches. It's a push. A tie.");
				} else {
					System.out.println("Dealer wins");
					playerAgent.decrementEarning();
				}
			}
			playerAgent.clearHand();
			dealerAgent.clearHand();

			System.out.println("Round " + round + " Player earning " + playerAgent.getEarning());
			System.out.println("Cards left " + blackJackGame.getDeck().cardsLeft());
		}
	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState playerPlaysARound(BlackjackAgent playerAgent, BoardState state) {
		Hand playerHand = playerAgent.hit();
		// System.out.println("Player hand is :" + playerHand.toString());
		state.setPlayerHand(playerHand);
		return state;
	}

	// TODO : Add action parameter to playARound like doubledown, split or hit
	private static BoardState dealerPlaysARound(BlackjackAgent dealerAgent, BoardState state) {
		Hand playerHand = dealerAgent.hit();
		// System.out.println("Player hand is :" + playerHand.toString());
		state.setDealerHand(playerHand);
		return state;
	}
}
