package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.*;

/**
 * The table view displays both stacks and also displays the game messages.
 *
 * @author Leo Ferrari
 *
 */
public class TableView extends JPanel {

	private Table table;
	private JLabel messageBox;
	private JPanel stackPanel;
	private Card topCard;
	private CardView placedStack;
	private CardView deckStack;
	private ImageIcon cardBack;

	/**
	 * The constructor for tableView
	 * 
	 * @param table, is needed as this is the View of that class
	 */
	public TableView(Table table) {
		this.table = table;
		table.setTableView(this);
		init();

	}

	/**
	 * the init method
	 */
	public void init() {
		this.setLayout(new BorderLayout());
		stackPanel = new JPanel(new GridLayout(1, 2));

		placedStack = new CardView(table.getPlacedCards().peek());
		placedStack.setShowFront(true);
		deckStack = new CardView();

		messageBox = new JLabel("GAME STARTED");

		try {

			Image img = ImageIO.read(getClass().getResource("../KartenBilder/UNO-Back.png"));
			deckStack.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		placedStack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

			}

		});
		placedStack.setBackground(Color.green);
		deckStack.setBackground(Color.green);
		deckStack.setBorderPainted(false);
		stackPanel.add(placedStack);
		stackPanel.add(deckStack);
		stackPanel.setBackground(Color.green);

		stackPanel.setBackground(Color.green);
		this.add(stackPanel, BorderLayout.CENTER);
		this.add(messageBox, BorderLayout.SOUTH);

	}

	/**
	 * changes the message in the messageBox
	 * 
	 * @param message, the message that should be set
	 */
	public void message(String message) {
		messageBox.setText(message);
	}

	/**
	 * updates the top card of the deck
	 * 
	 * @param card, the card that should be updated
	 */
	public void changeTopCard(Card card) {

		stackPanel.remove(placedStack);
		stackPanel.remove(deckStack);

		placedStack = new CardView(card);
		placedStack.setBackground(Color.green);
		placedStack.setShowFront(true);
		placedStack.setBorderPainted(false);
		stackPanel.add(placedStack);
		stackPanel.add(deckStack);

	}

}
