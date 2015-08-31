package com.bo0tzz.util.cards;

public class Card {

	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return this.suit;
	}

	public Rank getRank() {
		return this.rank;
	}

    public void printName() {
		System.out.println("Suit: " + this.suit + " Rank: " + this.rank);
	}
}
