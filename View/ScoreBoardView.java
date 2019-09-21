package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.ScoreBoard;

/**
 * Displays the players scores.
 * 
 * @author LeoFerrari, Alexandra Wittwer, Raphael Graf
 *
 */
public class ScoreBoardView extends JPanel {

	private JLabel[] playerPoints;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;
	private JLabel player4;
	private JLabel punkte1;
	private JLabel punkte2;
	private JLabel punkte3;
	private JLabel punkte4;
	private ScoreBoard score;
	private JPanel panel;

	/**
	 * The Constructor for ScoreBoardView. Needs the Scoreboard Class.
	 * 
	 * @param score, needed to set the scores on the ScoreboardView
	 */
	public ScoreBoardView(ScoreBoard score) {

		init();

		setVisible(true);
	}

	/**
	 * initialises the class
	 */
	private void init() {
		player1 = new JLabel("Player 1: ");
		player2 = new JLabel("Player 2: ");
		player3 = new JLabel("Player 3: ");
		player4 = new JLabel("Player 4: ");
		// Aktueller Punktestand anzeigen
		punkte1 = new JLabel();
		punkte2 = new JLabel();
		punkte3 = new JLabel();
		punkte4 = new JLabel();
		playerPoints = new JLabel[4];
		panel = new JPanel();

		panel.setLayout(new GridLayout(4, 2));
		for (int i = 0; i < 4; i++) {
			playerPoints[i] = new JLabel("0pts");
		}

		panel.add(player1);
		panel.add(playerPoints[0]);
		panel.add(player2);
		panel.add(playerPoints[1]);
		panel.add(player3);
		panel.add(playerPoints[2]);
		panel.add(player4);
		panel.add(playerPoints[3]);

		add(panel, BorderLayout.WEST);

	}

	/**
	 * sets the Scores in the View.
	 */
	public void setScores() {
		for (JLabel label : playerPoints) {
			panel.remove(label);
		}
		for (int i = 0; i > 5; i++) {
			playerPoints[i] = new JLabel(score.getScores()[i] + "pts");
			panel.add(playerPoints[i]);
		}
	}
}
