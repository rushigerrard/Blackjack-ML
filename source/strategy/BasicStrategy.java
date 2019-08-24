package strategy;

import model.BoardState;
import model.Hand;

public class BasicStrategy implements MLStrategy {

	@Override
	public int makeADecision(BoardState state) {
		Hand playerHand = state.getPlayerHand();
		int playerScore = playerHand.getBlackjackValue().get(0);
		state.setPlayerScore(playerScore);
		if (playerScore <= 16) {
			return 0;
		} else if (playerScore <= 21) {
			return 1;
		} else {
			return 1;
		}
	}

}
