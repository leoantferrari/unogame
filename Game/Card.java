package Game;

/**
 * The Card Class is the class that stores the number and colour of the cards
 * being used in the game.
 * 
 * @author Leo Ferrari
 *
 */
public class Card implements Rules {

	// the card number
	private int number;
	// the value of the card
	private int value = NUMBER_CARD_VALUE;
	// colour of the card
	private CardColour colour;

	/**
	 * constructor class
	 * @param number, the number the card should have
	 * @param colour, the colour the card should have
	 */
	public Card(int number, CardColour colour) {
		this.colour = colour;
		this.number = number;
		setValue();
	}

	/**
	 * sets the value of the card
	 */
	public void setValue() {
		value = getNumber() * NUMBER_CARD;
	}

	/**
	 * gets the value of the card
	 * 
	 * @return value, the value of this card
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets the colour of the card
	 * 
	 * @param colour, the colour of the card which needs t be set.
	 */
	public void setColour(CardColour colour) {
		this.colour = colour;
	}

	/**
	 * gets the colour of the card
	 * 
	 * @return colour, the colour of the card
	 */
	public CardColour getColour() {
		return colour;
	}

	/**
	 * sets number of the card
	 * @param number, the number it is wet to
	 */
	public void setNumber(int number) {
		this.number = number;

	}

	/**
	 * gets the number of the card
	 * @return number, returns the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * the toString method
	 * 
	 * @return toString, thing that makes the string
	 */
	public String toString() {
		return colour.toString() + " Number " + number;
	}

}
