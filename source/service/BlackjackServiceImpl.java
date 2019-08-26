package service;

import java.util.List;

import model.Deck;
import model.Hand;

public class BlackjackServiceImpl implements BlackjackService {

	private Deck deck;

	private Hand hand;

	public BlackjackServiceImpl(Deck deck) {
		this.deck = deck;
	}

	@Override
	public Hand hit() {
		hand.addCard(deck.dealCard());
		return hand;

	}

	@Override
	public void stand() {

	}

	@Override
	public void doubleDown() {

	}

	@Override
	public List<Hand> split() {
		return null;
	}

	@Override
	public List<Integer> getHandValue() {
		return null;
	}

	@Override
	public Integer getBet() {
		return null;
	}

	@Override
	public void setBet(Integer bet) {

	}

	@Override
	public void shuffle() {
		deck.shuffle();
	}

	@Override
	public void clearHand() {
		hand.clear();
	}

	@Override
	public Hand startNewHand() {
		hand = new Hand();
		return hand;
	}

	@Override
	public boolean isDeckShort() {

		return (deck.cardsLeft() <= 13);

	}

}
