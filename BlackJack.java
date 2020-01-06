package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
	
	private static BlackJack blackjack;
	Deck spel = new Deck();
	List<Card> hand = new ArrayList();
	List<Card> Dhand = new ArrayList();
	static String quest = "%nVill du ha ett kort?%n hit %n-----%n stand %n-----%n reset or quit %n";
	
	public static BlackJack getInstance() {
		if(blackjack == null){
			blackjack = new BlackJack();
			return blackjack;
		}
		else{
			return blackjack
		}
	}

	private void hit() {
		hand.add(spel.draw());
		}

	private void Dhit() {
		if (Dscore() <= 16) {
		Dhand.add(spel.draw());
		}
	}

	private void stand() {
		while (Dscore() <= 16) {
			Dhit();
		}
		if (Dscore() == score()) {
			System.out.printf("Det blev lika! %n");
		}
		else if (Dscore()==21) {
			System.out.printf("Dealern fick 21 och vann %nDu har totalt: " +score() +"%n");
		}
		else if (score()==21) {
			System.out.printf("Du fick 21 och vann! Dealern har: " +Dscore());
		}
		else if (score() > 21 && Dscore() > 21) {
			System.out.printf("Du fick " +score() +"%nDealern fick " +Dscore() +"%nIngen vann %n");
		}
		else if (Dscore()<21 && Dscore() > score()  || score() > 21  ) {
			System.out.printf("Dealern fick " +Dscore() +" och vann!%nDu fick totalt: " +score() +"%n");
		}
		else if (score() > Dscore() && score()<21 || Dscore() > 21) {
			System.out.printf("Du fick: " +score() +" och vann! %nDealern fick totalt: " +Dscore() +"%n");
		}
		else {
		System.out.printf("ingen if sats nappade %n Du: " +score() +"%n Dealer: " +Dscore() +"%n");
		}
		System.out.printf("%nSkriv newgame för nytt spel! %n");
		
	}
	
	private void reset() {
		spel.shuffle();
		hand.removeAll(hand);
		Dhand.removeAll(Dhand);
		System.out.printf(quest);
	}
	private void standings() {
		if (blackjack.score()>21 || blackjack.Dscore()>21 || blackjack.score() == 21 || blackjack.Dscore()==21) {
			blackjack.stand();
			reset();
		}
		else {
		blackjack.skrivUt();
		System.out.printf("%nDu har: " +blackjack.score());
		System.out.printf("%nDealer har: " + blackjack.Dscore() +"%n");
		System.out.printf(quest);
		}
	}
	private int score() {
		int score = 0, value;
		for (int i = 0; i < hand.size(); i++) {
			value = hand.get(i).getValue();
			switch (value) {
			case 1:
				score += 11;
				break;
			case 11: case 12: case 13:
				score += 10;
				break;
			default:
				score += value;
				break;
			}
		} 
		return score;
		}

	private String skrivUt() {
		for (int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).toString());
		}
		return "";
	}
	private int Dscore() {
		int score = 0, value;

		for (int i = 0; i < Dhand.size(); i++) {
			value = Dhand.get(i).getValue();

			switch (value) {
			case 1:
				score += 11;
				break;
			case 11: case 12: case 13:
				score += 10;
				break;
			default:
				score += value;
				break;
			}
		}
		return score;
	}
	public void startGame() {
		blackjack.reset();
		while ( true) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNext("hit")) {
				blackjack.hit();
				blackjack.Dhit();
				blackjack.standings();
			}
			if (sc.hasNext("stand")) {
				blackjack.stand();
				}
			if (sc.hasNext("reset")) {
				blackjack.reset();
			}
			if (sc.hasNext("newgame")) {
				blackjack.reset();
			}
			if (sc.hasNext("quit")) {
				break;
			}
			}//Här är botten av loopen
	}
}

