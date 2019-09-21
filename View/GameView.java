package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;
import Game.Player;

/**
 * The Gameview is the View that joins all of the Views needed for the main
 * playing for the game.
 * 
 * @author Leo Ferrari
 *
 */
public class GameView extends JPanel {

	private Game game;
	private TableView tableView;
	private PlayerView currentPlayerView;
	private ArrayList<PlayerView> allPlayerViews;
	private JPanel stuff;
	private JPanel buttons;
	private JButton rules;
	private JButton quit;
	private ScoreBoardView score;
	private JLabel playerName;

	/**
	 * Constructor for GameView.
	 * 
	 * @param game, the game that belongs to the view
	 */
	public GameView(Game game) {

		this.game = game;
		this.setLayout(new BorderLayout());

		allPlayerViews = new ArrayList<PlayerView>();

		tableView = new TableView(game.getTable());
		for (Player player : game.getPlayers()) {
			allPlayerViews.add(new PlayerView(player, this));
		}

		rules = new JButton("Rules");
		quit = new JButton("Quit");

		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.quitGame();

			}
		});
		rules.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GamerulesView();

			}
		});
		buttons = new JPanel();
		stuff = new JPanel();
		playerName = new JLabel("Testing");
		score = new ScoreBoardView(game.getScoreBoard());
		buttons.setLayout(new GridLayout(1, 2));
		stuff.setLayout(new GridLayout(1, 3));

		buttons.add(rules);
		buttons.add(quit);

		stuff.add(score);
		stuff.add(buttons);
		stuff.add(playerName);

		add(stuff, BorderLayout.NORTH);

		setPlayerView();
		this.add(tableView);
		this.setVisible(true);

	}

	/**
	 * the PlayerView is set
	 */
	public void setPlayerView() {
		Player currentPlayer;
		currentPlayer = game.getPlayers()[0].getCurrentPlayer();
		currentPlayerView = findPlayerView(currentPlayer);
		playerName.setText("Current turn: Player " + currentPlayer.getPlayerNum());
		this.add(currentPlayerView, BorderLayout.SOUTH);
	}

	/**
	 * return the playerView for the supplied player.
	 * 
	 * @param player, finds the view of a player
	 * @return returns the player view.
	 */
	public PlayerView findPlayerView(Player player) {
		for (PlayerView pw : allPlayerViews) {
			if (pw.getPlayer() == player) {
				return pw;
			}
		}
		return null;
	}

	/**
	 * gives the tableView a message to display
	 * 
	 * @param message, a quick message to be displayed on screen
	 */
	public void message(String message) {
		tableView.message(message);
	}
}
