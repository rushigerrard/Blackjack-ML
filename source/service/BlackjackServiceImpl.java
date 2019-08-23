package service;

import java.util.List;

import model.Card;
import model.Deck;
import model.Hand;

public class BlackjackServiceImpl implements BlackjackService {

	private Deck deck;

	public BlackjackServiceImpl(Deck deck) {
		this.deck = deck;
	}
	@Override
	public Card hit() {
		return deck.dealCard();

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

}
