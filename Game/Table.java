package Game;

import java.util.Collections;
import java.util.Stack;

import View.TableView;

/**
 * The table class houses the deck and the placed cards. It also has a view.
 * This is like the game board of the game.
 * 
 * @author Leo Ferrari
 *
 */
public class Table {

	private Stack<Card> deck;
	private Stack<Card> placedCards;

	private TableView view;

	/**
	 * The Constructor for table. Creates the deck and the placedCards. Then it
	 * populates the deck.
	 */
	public Table() {

		// initialise empty deck
		deck = new Stack<Card>();
		// initialise empty placed cards deck
		placedCards = new Stack<Card>();

		populateDeck();
		placedCards.push(deck.pop());

	}

	/**
	 * This method populates the deck with cards of every colour
	 */
	public void populateDeck() {

		// generates a card for every number with colour red(1)
		for (int i = 0; i < 10; i++) {

			deck.add(new Card(i, CardColour.RED));
			if (i != 0) {
				deck.add(new Card(i, CardColour.RED));
			}
		}
		// generates a card for every number with colour green(2)
		for (int i = 0; i < 10; i++) {
			deck.add(new Card(i, CardColour.GREEN));
			if (i != 0) {
				deck.add(new Card(i, CardColour.GREEN));
			}
		}
		// generates a card for every number with colour yellow(3)
		for (int i = 0; i < 10; i++) {
			deck.add(new Card(i, CardColour.YELLOW));
			if (i != 0) {
				deck.add(new Card(i, CardColour.YELLOW));
			}
		}
		// generates a card for every number with colour blue(4)
		for (int i = 0; i < 10; i++) {
			deck.add(new Card(i, CardColour.BLUE));
			if (i != 0) {
				deck.add(new Card(i, CardColour.BLUE));
			}
		}

		shuffleDeck();

	}

	/**
	 * this method shuffles the deck
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}

	/**
	 * This method is called when the player wants to pick up a card. First the deck
	 * is checked if there are any cards. If there are no cards, then the bottom
	 * cards of placedCards is added to the deck. Then the top card of placedCards
	 * is readded to placedCards. Then the player is given the top card from the
	 * deck.
	 */
	public Card pickUpCard() {
		if (deck.size() == 0) {
			Card topPlacedCard = placedCards.pop();
			while (placedCards.size() > 0) {
				deck.push(placedCards.pop());
			}
			placedCards.push(topPlacedCard);
		}

		return deck.pop();
	}

	/**
	 * This method checks to see if the card can be placed, and places it if it can
	 */
	public boolean placeCard(Card card) {

		Card topPlacedCard = placedCards.peek();

		System.out.println(topPlacedCard.toString() + " is the top placed card");
		// checks to see if the card has the same number or the same colour
		if (card.getNumber() == topPlacedCard.getNumber() || card.getColour() == topPlacedCard.getColour()) {
			// pushes card on to top of placed card deck
			placedCards.push(card);
			view.changeTopCard(card);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * returns placedCards
	 * 
	 * @return placedCards
	 */
	public Stack<Card> getPlacedCards() {
		return placedCards;
	}

	/**
	 * sets the tableView
	 * 
	 * @param view
	 */
	public void setTableView(TableView view) {
		this.view = view;
	}

}
