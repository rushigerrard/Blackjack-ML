package agent;

import controller.BlackjackController;
import controller.BlackjackControllerImpl;

public class PlayerAgent implements BlackjackAgent {

	static Integer earning = 1000;

	public static void main(String[] args) {

		BlackjackController playerController = new BlackjackControllerImpl();
		BlackjackController dealerController = new BlackjackControllerImpl();
		
		Integer bet = 100;
		playerController.setBet(bet);

		// Start playing
		/*
		 * while (true): Input the user's bet if the bet is 0: Break out of the
		 * loop User plays a game of Blackjack if the user won the game Pay off
		 * the user's bet (money = money + bet) else Collect the user's bet
		 * (money = money - bet) If the user is out of money: Break out of the
		 * loop.
		 */

		int round = 0;
		while (earning >= 0) {
			System.out.println("Round " + round + " chips " + earning);
			round++;

			Integer playerScore = 0;
			// One of the dealer card is visible
			// Our ML algorithm will take in this as an input parameter as well
			Integer dealerScore = dealerController.hit().get(0);
			
			while(playerScore < 21){
				playerScore += playerController.hit().get(0);
				System.out.println("Player score : " + playerScore);
				// LOT OF ML STUFF WILL COME IN HERE
				if(playerScore > 15)
					break;
			}
			if (playerScore > 21){ // player score > 21 | player goes bust
				earning = earning - bet;
			}
			else if (playerScore == 21) { // player score = 21 | player wins blackjack game
				earning = earning + bet;
			}
			else { // player score is between 15 and 21
				/*
				 * Dealer agent keeps hitting till score is <= 16, stays on 17 or above
				*/
				while(dealerScore <= 16){
					dealerScore += playerController.hit().get(0);
					
				}
				if (dealerScore > 21) { // dealer score > 21 | dealer goes bust
					earning = earning + bet;
				} else if (dealerScore >= playerScore) { // dealer score more
															// than player score
															// | dealer wins
					earning = earning - bet;
				}
			}
						
			}
	}

}
