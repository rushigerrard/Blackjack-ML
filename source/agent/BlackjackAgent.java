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

	/**
	 * makeADecision returns 0 - hit 1 - stand 2 - doubleDown 3 - split
	 * 
	 * @param state
	 * @return
	 */
	int makeADecision(BoardState state);
}
