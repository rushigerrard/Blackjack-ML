package agent;

import model.BoardState;

/**
 * BlackjackAgent will have a controller object to play the gamee It will also
 * contain a makeDecision method which will dictate the strategy used The ML
 * logic for a player should be provided through these agents
 * 
 * @author rushikesh
 *
 */
public interface BlackjackAgent {

	int makeADecision(BoardState state);
}
