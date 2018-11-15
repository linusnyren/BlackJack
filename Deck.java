package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> cards = new ArrayList<>();
	
	public Deck() {
		int pos = 0;
		for (int i = 1; i < 14; i++) {
			cards.add(pos, new Card(i, Suit.Hearts));
			pos++;
			cards.add(pos, new Card(i, Suit.Clubs));
			pos++;
			cards.add(pos, new Card(i, Suit.Spades));
			pos++;
			cards.add(pos, new Card(i, Suit.Diamonds));
			pos++;
		}
	}
	
	public Card draw() {
		Collections.shuffle(cards);
	    Card random = cards.get(0);
	    cards.remove(random);
	    return random;
	}
	public void shuffle() {
		List<Card> shuffledCards = new ArrayList<>();
		Random random = new Random();
		Card card;
		while ( cards.size() > 0) {
			card = cards.get(random.nextInt(cards.size()));
			shuffledCards.add(card);
			cards.remove(card);
		}
		cards = shuffledCards;
	}
}
