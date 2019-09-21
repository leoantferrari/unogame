package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Game.Game;
import Game.Player;
import Game.Test;

/**
 * This Class class manages all of the views.
 * 
 * @author Leo Ferrari
 *
 */
public class ViewManager extends JFrame {

	private Game game;
	private Player[] players;
	private MenuView menu;
	private GameView gameView;
	private ScoreBoardView score;

	/**
	 * Constructor needs the game so that it can show the game
	 * 
	 * @param game, the game that is needed to make the rest
	 */
	public ViewManager(Game game) {
		super("UnoGame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.game = game;
		players = game.getPlayers();

		startMenu();
		this.setSize(1920, 1080);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);

	}

	/**
	 * displays the start menu
	 */
	public void startMenu() {
		menu = new MenuView(game);
		this.add(menu);
	}

	/**
	 * starts the game
	 */
	public void startGame() {
		gameView = new GameView(game);
		this.remove(menu);
		this.add(gameView);
	}

	/**
	 * ends the game and shows the scoreboard
	 */
	public void endGame() {
		score = new ScoreBoardView(game.getScoreBoard());

		this.remove(gameView);
		this.add(score);
		JDialog d = new JDialog();
		d.setLayout(new BorderLayout());
		d.add(new JTextArea("Player " + game.getPlayers()[0].getCurrentPlayer().getPlayerNum() + "has won the game"),
				BorderLayout.CENTER);
		JPanel f = new JPanel(new GridLayout(1, 2));
		JButton a = new JButton("AGAIN");
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Test();
				dispose();
			}
		});
		JButton b = new JButton("QUIT");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();

			}
		});

		f.add(a);
		f.add(b);
		d.add(f, BorderLayout.SOUTH);
		d.pack();
		d.setVisible(true);

	}
}
