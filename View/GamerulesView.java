package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A Dialog which appears and shows the Rules of the Game.
 * 
 * @author Leo Ferrari, Alexandra Wittwer, Raphael Graf
 *
 */
public class GamerulesView extends JDialog {

	private JTextArea rules;
	private JButton back;

	public GamerulesView() {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		init();

		setVisible(true);
	}

	/**
	 * initialises the GamerulesView, by adding the text to a TextArea.
	 */
	private void init() {
		rules = new JTextArea("Ziel des Spiels\r\n" + "\r\n"
				+ "Das Ziel beim klassischen UNO ist es als Erster Spieler 500 Punkte zu erzielen. Pro Runde erh�lt der Spieler Punkte, welcher als Erster alle seine Karten auf der Hand ablegt. Punkte gibt es für alle Karten, die die übrigen Mitspieler noch auf der Hand. \r\n"
				+ "\r\n" + "Spielverlauf\r\n" + "\r\n"
				+ "Der erste Spieler legt eine Karte von seiner Hand auf den Ablegestapel. Dabei gilt: Eine Karte kann nur auf eine Karte der gleichen Farbe oder der gleichen Zahl gelegt werden. Kann ein Spieler keine passende Karte legen, so muss er eine Strafkarte vom verdeckten Stapel ziehen. Diese Karte kann er sofort wieder ausspielen, sofern diese passt. Hat er keine passende Karte ist der nächste Spieler an der Reihe. Wer die vorletzte Karte ablegt, muss „UNO!“ rufen und signalisiert damit, dass er nur noch eine Karte auf der Hand hat. Vergisst ein Spieler das so muss er 2 Strafkarten ziehen. Die Runde gewinnt derjenige, welcher die letzte Karte abgelegt hat. Die Punkte werden addiert und eine neue Runde wird gespielt. \r\n"
				+ "\r\n" + "Aktionskarten \r\n" + "\r\n"
				+ "Im Spiel gibt es schwarze Aktionskarten mit unterschiedlichen Funktionen, welche nachfolgenderkl�rt werden. \r\n"
				+ "\r\n" + "ZIEH ZWEI KARTEN \r\n"
				+ "Wenn diese Karte gelegt wird, muss der nächste Spieler 2 Karten ziehen und darf in dieser Runde keine Karten ablegen. Diese Karte kann nur auf eine Karte mit entsprechender Farbe oder andere zieh Zwei Karten gelegt werden. Wenn sie zu Beginn des Spiels aufgedeckt wird, gelten dieselben Regeln. \r\n"
				+ "\r\n" + "RETOUR KARTE \r\n"
				+ "Bei dieser Karte ändert sich die Spielrichtung. Wenn bisher nach links gespielt wurde, wird nun nach rechts gespielt und umgekehrt. Die Karte kann nur auf eine entsprechende Farbe oder eine andere Retour Karte gelegt werden. Wenn diese Karte zu Beginn des Spiels gezogen wird, fängt der Geber an und dann setzt der Spieler zu seiner Rechten anstatt zu seiner Linken das Spiel fort.\r\n"
				+ "\r\n" + "AUSSETZEN KARTE\r\n"
				+ "Nachdem diese Karte gelegt wurde, wird der nächste Spieler „übersprungen“. Die Karte kann nur auf eine andere mit entsprechender Farbe oder eine andere Aussetzen Kartegelegt werden. Wenn diese Karte zu Beginn des Spiels gezogen wird, wird der Spieler zur Linken des Gebers „übersprungen“ und der Spieler zur Linken dieses Spielers setzt das Spiel fort.\r\n"
				+ "\r\n" + "FARBENWAHLKARTE\r\n"
				+ "Der Spieler, der diese Karte legt, entscheidet welche Farbe als nächstes gelegt werden soll. Auch die schon liegende Farbe darf gewählt werden. Ein Farbenwahl Karte darf auch dann gelegt werden, wenn der Spieler eine andere Karte legen könnte. Wenn eine Farbenwahl Karte zu Beginn des Spiels gezogen wird, entscheidet der Spieler zur Linkendes Gebers, welche Farbe als nächstes gelegt werden soll.\r\n"
				+ "\r\n" + "ZIEH VIER KARTEN\r\n"
				+ "Der Spieler, der sie legt, entscheidet, welche Farbe als nächstes gelegt werden soll. Zudem muss der nächste Spieler 4 Karten von dem Kartenstapel nehmen. Er darf in dieser Runde keine Karte ablegen. Wird diese Karte zu Beginn des Spiels gezogen, wird sie auf den Stapelzurückgelegt und eine andere Karte wird gezogen. \r\n"
				+ "\r\n" + "Strafen\r\n" + "\r\n" + "UNO: \r\n"
				+ "Vergisst ein Spieler nach dem legen seiner vorletzten Karte UNO! zu rufen so muss er 2 Strafkarte ziehen. \r\n"
				+ "\r\n" + "Punkte \r\n" + "\r\n"
				+ "Eine Karte ist doppelt so viele Punkte wert wie die Zahl ist (als karte 5 = 10 Punkte, Karte 9 = 18 Punkte). Spezialkarten geben je 20 Punkte.\r\n"
				+ "\r\n" + " \r\n" + "");
		rules.setLineWrap(true);
		rules.setEditable(false);
		JScrollPane scrolly = new JScrollPane(rules);

		back = new JButton("Back");

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		getContentPane().add(scrolly, BorderLayout.CENTER);
		getContentPane().add(back, BorderLayout.SOUTH);
		setSize(600, 700);
	}

}
