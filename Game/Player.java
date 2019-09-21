package Game;

import java.util.ArrayList;

import View.PlayerView;

/**
 * This Class is the Player-Class. This class controls the PlayerView and also
 * contains most of the logic of the whole game.
 * 
 * @author Leo Ferrari
 *
 */
public class Player implements Rules {

	private int number;
	private Player[] players;
	private Player currentPlayer;
	private Boolean myTurn = false;
	private Boolean saidUno = false;
	private Boolean wonGame = false;
	private Boolean placedCard = false;
	private Boolean pickedUpCard = false;
	private Boolean punishment = false;
	private Game game;

	private int points = 0;
	private PlayerView playerView;

	private Table table;
	private ArrayList<Card> hand;

	/**
	 * This Classes Constructor
	 * 
	 * @param number needs a player number
	 * @param game   needs the game object
	 */
	public Player(int number, Game game) {
		this.number = number;
		table = game.getTable();
		this.game = game;

		// initialise empty hand
		hand = new ArrayList<Card>();

	}

	/**
	 * picks up card from table. Needs to first check if this pick-up is meant to be
	 * as punishment, then check to see if the player has already picked up a card.
	 * If the player already has picked up a card, no card will be picked up.
	 * 
	 * @return boolean: true for success, false for failure
	 */
	public boolean pickUpCard() {
		if (punishment == true) {
			for (int i = 0; i < AMOUNT_OF_CARDS_TO_PICK_UP; i++) {
				hand.add(table.pickUpCard());
			}
			playerView.message(
					"Player " + number + " has picked up " + AMOUNT_OF_CARDS_TO_PICK_UP + " cards as punishment");
			punishment = false;
			return true;
		} else if (pickedUpCard != true) {
			saidUno = false;
			hand.add(table.pickUpCard());
			pickedUpCard = true;
			// playerView.resetHand();
			playerView.message("A Card has been picked up.");
			return true;
		} else {
			playerView.message("You have already picked up a card.");
			return false;
		}

	}

	/**
	 * Attempts to place card on the table, if successful, true, otherwise false
	 * 
	 * @param card that need to be placed
	 * @return true if successful, false if failure
	 */
	public boolean placeCard(Card card) {
		if (placedCard != true) {
			if (table.placeCard(card) == true) {
				hand.remove(card);

				placedCard = true;

				playerView.message(card.toString() + " has been placed");
				if (saidUno == true && getHand().size() == 0) {

					wonGame = true;
					hand.clear();
					game.roundComplete();
				} else if (saidUno == false && hand.size() == 0) {

					punishment = true;
					this.pickUpCard();

				}

				return true;

			} else {
				playerView.message(card.toString() + " couldnt be placed");

				return false;
			}
		} else {
			playerView.message("You have already placed a card");
			return false;
		}
	}

	/**
	 * method that initiates the beginning of the game and also gets the players
	 * first hand. Then it sets the Current Player to the one defined in the Rules.
	 * 
	 * @param players that need to be initiated
	 */
	public void initiateGame(Player[] players) {
		this.players = players;

		this.setSaidUno(false);
		// this.card
		for (int i = 0; i < FIRST_HAND; i++) {
			hand.add(table.pickUpCard());
		}

		setCurrentPlayer(players[FIRST_PLAYER]);

	}

	/**
	 * sets the current Player thats playing the game
	 * 
	 * @param player that needs to be set as current player
	 */
	public void setCurrentPlayer(Player player) {
		currentPlayer = player;
		if (this == player) {
			myTurn = true;
			if (playerView != null) {
				playerView.setCurrentView(true);
			}

		} else {
			myTurn = false;
			if (playerView != null) {
				playerView.setCurrentView(false);
			}

		}
	}

	/**
	 * called when player ends his turn, changes the current Player to the next
	 * Player and changes myTurn to false
	 */
	public void endTurn() {
		if (placedCard == true || pickedUpCard == true) {
			placedCard = false;
			pickedUpCard = false;
			for (Player player : players) {
				playerView.setCurrentView(false);
				if (number == 3) {
					player.setCurrentPlayer(players[0]);

				} else {
					player.setCurrentPlayer(players[number + 1]);
				}

			}

			myTurn = false;
			playerView.message("Player " + number + " has ended their turn, now its Player " + (number + 1) + "s turn");

		} else {
			playerView.message("You need to either pick up a card or place a card to continue.");

		}

	}

	/**
	 * returns the current Player of the game
	 * 
	 * @return currentPlayer, which is the current Player
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * returns the players hand of cards
	 * 
	 * @return hand
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * the players toString method
	 * 
	 * @return toString
	 */
	public String toString() {
		String h = "";
		h += "Player " + number + ":";
		for (Card card : hand) {
			h += card.toString() + "\n";
		}
		return h;
	}

	/**
	 * when player presses Uno-Button this needs to be called
	 */
	public void sayUno() {
		if (saidUno != true) {
			if (hand.size() > 1) {
				playerView.message("You have more than one card.");
			} else {
				saidUno = true;
				playerView.message("Player " + number + " has said Uno");
			}

		} else {
			playerView.message("You already said Uno");
		}
	}

	/**
	 * set SaidUno to bool
	 * 
	 * @param bool, if uno has been set. True for yes, False for no.
	 */
	public void setSaidUno(Boolean bool) {
		saidUno = bool;
	}

	/**
	 * sets if the player has won with bool value
	 * 
	 * @param bool, if true, player has won the game, if false, he hasnt yet won the
	 *              game.
	 */
	public void setWonGame(Boolean bool) {
		wonGame = bool;
	}

	/**
	 * returns the amount of points that the player has
	 * 
	 * @return the points that the player has
	 * 
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * sets the amount of points a player has
	 * 
	 * @param points, the amount of points the player should be set to
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * adds the amount of points to what the player has
	 * 
	 * @param points, the points that should be added
	 */
	public void addPoints(int points) {
		this.points += points;
		// game.getScoreBoard().setScores();
	}

	/**
	 * counts the amount of point the player would receive if they won
	 * 
	 * @return int the amount of points a player receives if he would win
	 */
	public int countPoints() {
		int provPoints = 0;
		for (Player player : players) {
			for (int i = 0; i < player.getHand().size(); i++) {
				provPoints += player.getHand().get(i).getValue();

			}
		}
		playerView.message("Player " + number + " has " + provPoints + " points");
		return provPoints;
	}

	/**
	 * returns the Player number
	 * 
	 * @return number, the player number
	 */
	public int getPlayerNum() {
		return number;
	}

	/**
	 * Sets the playerView that belongs to the player
	 * 
	 * @param pl is the view that is set
	 */
	public void setView(PlayerView pl) {
		playerView = pl;
	}

	/**
	 * Checks if the Player has won the round
	 * 
	 * @return wonGame, if return is true, this player has won the game
	 */
	public boolean getPlayerWon() {
		return wonGame;
	}

	/**
	 * sets the attribute setPlacedCard to true/false.
	 * 
	 * @param bool, if a card has been set
	 */
	public void setPlacedCard(boolean bool) {
		placedCard = bool;
	}

	/**
	 * resets the hand
	 */
	public void resetHand() {
		hand.clear();
		if (playerView == null) {

		} else {
			playerView.revalidate();
		}

	}

}
