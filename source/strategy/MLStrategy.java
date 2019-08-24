package strategy;

import model.BoardState;

/**
 * Have a functional interface to implement various ML strategies
 * 
 * @author rushikesh
 *
 */
public interface MLStrategy {

	int makeADecision(BoardState state);
}
