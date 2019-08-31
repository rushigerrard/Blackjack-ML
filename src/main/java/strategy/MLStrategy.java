package strategy;

import model.BoardState;
import model.Decision;

/**
 * Have a functional interface to implement various ML strategies
 * 
 * @author rushikesh
 *
 */
public interface MLStrategy {

	Decision makeADecision(BoardState state);
}
