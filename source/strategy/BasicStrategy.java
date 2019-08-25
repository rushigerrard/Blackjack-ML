package strategy;

import model.BoardState;
import model.Decision;
import model.Hand;

public class BasicStrategy implements MLStrategy {

	@Override
	public Decision makeADecision(BoardState state) {
		Hand playerHand = state.getPlayerHand();
		int playerScore = playerHand.getBlackjackValue().get(0);
		state.setPlayerScore(playerScore);
		if (playerScore <= 16) {
			return Decision.HIT;
		}
		return Decision.STAND;
	}

}
