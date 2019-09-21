package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Game.Card;
import Game.Player;

/**
 * The CardView which takes the image from a file and matches it to a card
 * class. Then it makes a Button out of it.
 * 
 * @author Leo Ferrari
 *
 */
public class CardView extends JButton {

	// needs a card
	private Card card;
	private boolean showFront = false;

	/**
	 * empty constructor for cards without a front
	 */
	public CardView() {

	}

	/**
	 * Constructor which initialises card. Also calls getImage method.
	 * 
	 * @param card, the card that should be displayed in the card view
	 */
	public CardView(Card card) {
		super();
		this.card = card;

		getImage();
	}

	/**
	 * getImage() sets the image of the CardView. Uses the card class to find out
	 * what card image needs to be set.
	 */
	public void getImage() {

		try {
			String fileColourName = "";
			if (showFront == true && card != null) {
				switch (card.getColour()) {
				case RED:
					fileColourName = "red";
					break;
				case BLUE:
					fileColourName = "blue";
					break;
				case GREEN:
					fileColourName = "green";
					break;
				case YELLOW:
					fileColourName = "Yel";
					break;
				}
				Image img = ImageIO
						.read(getClass().getResource("../KartenBilder/" + fileColourName + card.getNumber() + ".PNG"));
				setIcon(new ImageIcon(img));

			} else {
				Image img = ImageIO.read(getClass().getResource("../KartenBilder/UNO-Back.png"));
				Image imgScaled = img.getScaledInstance(500, 600, Image.SCALE_DEFAULT);

				setIcon(new ImageIcon(imgScaled));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * is used to set the CardView to show the front or back of the card.
	 * 
	 * @param bool, if true, the front of the card will be shown, if false the back
	 */
	public void setShowFront(boolean bool) {
		showFront = bool;
		getImage();
	}

	/**
	 * This method gets the card in the CardView
	 * 
	 * @return card, returns the card in the CardView
	 */
	public Card getCard() {
		return card;
	}

}
