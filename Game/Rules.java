package Game;

import java.awt.Color;

/**
 * The Rules interface sets constants for some of the rules in the game. It
 * would have been used for an options menu, but there isn't enough time left.
 * 
 * @author Leo Ferrari
 *
 */
public interface Rules {

	int FIRST_HAND = 7;
	Color[] UNO_COLOURS = { Color.red, Color.blue, Color.green, Color.yellow };
	int FIRST_PLAYER = 0;
	int NUMBER_CARD_VALUE = 10;
	int AMOUNT_OF_CARDS_TO_PICK_UP = 2;
	int NUMBER_CARD = 2;

}
