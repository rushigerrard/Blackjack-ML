package strategy;

import java.util.List;

import model.BoardState;
import model.Decision;
import model.Hand;

public class BasicStrategy implements MLStrategy {

	@Override
	public Decision makeADecision(BoardState state) {
		Hand playerHand = state.getPlayerHand();
		List<Integer> playerScoreList = playerHand.getBlackjackValue();
		Integer softScore = playerScoreList.get(0);
		if (playerScoreList.size() > 1) {
			Integer hardScore = playerScoreList.get(1);
		}
		state.setPlayerScore(playerHand.getBlackjackValue());
		if (softScore <= 16) {
			return Decision.HIT;
		}
		return Decision.STAND;
	}

}
