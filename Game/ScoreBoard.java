package Game;

import View.ScoreBoardView;

/**
 * The Scoreboard class, which keeps track of the scores of all the players.
 * 
 * unfinished.
 * 
 * @author Leo Ferrari
 *
 */
public class ScoreBoard {

	private int[] scores;
	private String scoreName1;
	private String scoreName2;
	private String scoreName3;
	private String scoreName4;
	private Player[] players;
	private ScoreBoardView score;

	/**
	 * The Scoreboard constructor,the players are fed into the constructor.
	 * 
	 * @param players the players neeed to set the scores
	 */
	public ScoreBoard(Player[] players) {
		this.players = players;
		scores = new int[4];

	}

	/**
	 * Sets the view of this class
	 * 
	 * @param score the view that belongs to this class
	 */
	public void setView(ScoreBoardView score) {
		this.score = score;

	}

	/**
	 * Sets the scores of the view
	 */
	public void setScores() {
		for (Player player : players) {
			scores[player.getPlayerNum()] = player.getPoints();
		}
		score.setScores();

	}

	/**
	 * gets the scores
	 * 
	 * @return the scores of the players
	 */
	public int[] getScores() {
		return scores;
	}

}
