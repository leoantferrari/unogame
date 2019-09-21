package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Game.*;

/**
 * The PlayerView displays the Players hand and also the buttons NextTurn,
 * PickUpCard and SayUno.
 * 
 * @author Leo Ferrari
 *
 */
public class PlayerView extends JPanel {

	private JPanel handView;
	private ArrayList<Card> hand;
	private ArrayList<JButton> handButtons;

	private JPanel buttons;
	private JButton sayUno;
	private JButton nextTurn;
	private JButton pickUpCard;
	private JLabel playerName;
	private PlayerView playerView;
	private GameView gameView;

	private Player player;

	/**
	 * PlayerView Constructor, needs Player and the gameView.
	 * 
	 * @param player, the player which is bound to the view
	 * @param gameView, the gameView class which created this class
	 */
	public PlayerView(Player player, GameView gameView) {
		this.player = player;
		this.gameView = gameView;
		this.player.setView(this);

		this.setLayout(new BorderLayout());
		buttons = new JPanel(new GridLayout(4, 1));
		sayUno = new JButton("sayUno");
		pickUpCard = new JButton("Pick Up Card");

		nextTurn = new JButton("nextTurn");
		playerName = new JLabel("Player " + player.getPlayerNum());

		nextTurn.addActionListener(new ActionListener() {

			@Override
			/**
			 * when pressed, a new turn is begun. It ends the current players turn and
			 * updates the PlayerView in GameVIew.
			 */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.endTurn();
				gameView.setPlayerView();
			}

		});
		sayUno.addActionListener(new ActionListener() {

			@Override
			/**
			 * when pressed, the sayUno method is called in player
			 */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.sayUno();
			}

		});
		pickUpCard.addActionListener(new ActionListener() {

			@Override
			/**
			 * Button to pick up card. When pressed, attempts to pick up card, if successful
			 * resets the hand view.
			 */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (player.pickUpCard() == true) {
					resetHand();
				}
				;
			}

		});
		buttons.add(sayUno);
		buttons.add(nextTurn);
		buttons.add(pickUpCard);
		buttons.add(playerName);

		resetHand();

		this.add(handView, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.WEST);

		setVisible(true);

	}

	/**
	 * sets the attribute setVisible to true or false. Unused method
	 * 
	 * @param bool true == yes, false == no
	 */
	public void setCurrentView(boolean bool) {
		setVisible(bool);
	}

	/**
	 * With this method the HandView is reset. that means the cards are reshown
	 */
	public void resetHand() {
		setVisible(false);
		try {
			remove(handView);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		handView = new JPanel(new GridLayout(1, player.getHand().size()));
		for (Card card : player.getHand()) {
			CardView but = new CardView(card);
			but.setBorderPainted(false);
			but.setBackground(Color.DARK_GRAY);
			but.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (player.placeCard(card) == true) {
						// handView.remove(but);
						resetHand();
					} else {

					}

				}

			});
			but.setShowFront(true);
			handView.add(but);
			add(handView);
			setVisible(true);
		}
	}

	/**
	 * Returns the player that is bound to the PlayerView
	 * 
	 * @return player, the player that is bound to PlayerView
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * gives the gameView a message to display
	 * 
	 * @param message, the message needed to be sent
	 */
	public void message(String message) {
		gameView.message(message);
	}
}
