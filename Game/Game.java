package Game;

import java.util.ArrayList;

import View.ViewManager;

/**
 * The Game Class puts the views, models and controllers together, it also
 * creates all the game objects and sends the signal to the players to begin the
 * game.
 * 
 * @author Leo Ferrari
 *
 */
public class Game implements Rules {

	private Player[] players;

	private Table table;

	private ScoreBoard scoreBoard;

	private ViewManager view;

	/**
	 * Constructor Class which generates the table and players of the game.
	 */
	public Game() {
		table = new Table();
		// makes an array with 4 playerslots
		players = new Player[4];

		// initiliazes 4 Players
		for (int i = 0; i < 4; i++) {
			players[i] = new Player(i, this);
		}
		view = new ViewManager(this);
		scoreBoard = new ScoreBoard(players);
		// test();
	}

	/**
	 * This method tests the Game elements
	 */
	public void test() {

		startGame();
		players[0].addPoints(502);
	}

	/**
	 * sends signal to players to start game and also gives them reference to other
	 * players
	 */
	public void startGame() {
		for (Player player : players) {

			player.resetHand();
			player.initiateGame(players);

		}

		view.startGame();
		// scoreBoard.setScores();
	}

	/**
	 * get the table
	 * 
	 * @return table, the table of the game
	 */
	public Table getTable() {
		return table;
	}
	/**
	 * gets all the players of the game
	 * @return players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * returns the scoreboard
	 * 
	 * @return scoreboard
	 */
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	/**
	 * quits the game
	 */
	public void quitGame() {
		view.dispose();
	}

	/**
	 * when a player has no cards left, this method is called, to count and add the
	 * points the player would receive.
	 */
	public void roundComplete() {
		for (Player player : players) {
			if (player.getPlayerWon() == true) {

				player.addPoints(player.countPoints());
				player.setWonGame(false);
				// scoreBoard.setScores();

				view.endGame();

			}
		}
		table.populateDeck();
		for (Player player : players) {
			player.resetHand();
			player.initiateGame(players);
		}

	}
}
