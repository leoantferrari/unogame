package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;

/**
 * The MenuView Class. Its like a start screen for the game.
 * 
 * @author leoan
 *
 */
public class MenuView extends JPanel {

	private JButton startGame;
	private JButton options;
	private JLabel logo;

	private Game game;

	/**
	 * Constructor for MenuView, need the game class to generate stuff.
	 * 
	 * @param game, the game that the menuView need to work
	 */
	public MenuView(Game game) {

		this.game = game;
		Font bBold = new Font("Arial", Font.BOLD, 80);

		startGame = new JButton("START GAME");
		startGame.setBackground(Color.yellow);
		startGame.setFont(bBold);

		startGame.setBackground(Color.red);
		this.setLayout(new GridLayout(3, 3));

		JPanel filler1 = new JPanel();
		JPanel filler2 = new JPanel();
		JPanel filler3 = new JPanel();
		JPanel filler4 = new JPanel();
		JPanel filler5 = new JPanel();
		JPanel filler6 = new JPanel();
		JPanel filler7 = new JPanel();
		JPanel filler8 = new JPanel(new BorderLayout());

		filler1.setBackground(Color.red);
		filler2.setBackground(Color.red);
		filler3.setBackground(Color.red);
		filler4.setBackground(Color.red);
		filler5.setBackground(Color.red);
		filler6.setBackground(Color.red);
		filler7.setBackground(Color.red);

		this.add(filler1);

		setBackground(Color.red);
		Image img;
		logo = new JLabel();
		try {
			img = ImageIO.read(getClass().getResource("../KartenBilder/unoLogo.png"));
			Image imgScaled = img.getScaledInstance(100, 200, Image.SCALE_DEFAULT);
			ImageIcon imgIcon = new ImageIcon(img);
			logo.setIcon(imgIcon);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		filler8.add(logo, BorderLayout.CENTER);

		startGame.setBorderPainted(false);

		startGame.addActionListener(new ActionListener() {

			@Override
			/**
			 * ButtonListener that starts the game
			 */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				setVisible(false);
				game.startGame();

			}

		});

		this.add(logo);
		this.add(filler2);
		this.add(filler3);
		this.add(startGame);
		this.add(filler5);
		this.add(filler6);
		this.add(filler7);

	}

}
