package game;

enum Symbol {
	EMPTY, CIRCLE, CROSS;
}

/**
 * Diego's super cool TicTacToe game that he programmed because engineering!
 * 
 * @author Diego's Beloved PC
 *
 */
public class TicTacToeGame {

	private Symbol TileGrid[][] = new Symbol[3][3];

	// Cross starts first
	private Symbol CurrentTurn = Symbol.CROSS;

	private int CrossScore;
	private int CircleScore;
	private boolean Over;
	private boolean Won;

	/**
	 * Default constructor
	 */
	public TicTacToeGame() {
		for (int i = 0; i < TileGrid.length; i++) {
			for (int j = 0; j < TileGrid.length; j++) {
				TileGrid[i][j] = Symbol.EMPTY;
			}
		}
	}

	/**
	 * Play a turn of TTT
	 * 
	 * @param row
	 * @param col
	 */
	public void claimTile(int row, int col) {
		if (row > 2 || col > 2 || Over || TileGrid[row][col] != Symbol.EMPTY) {
			System.out.println("My sensors indicate game is over");
			return;
		}
		TileGrid[row][col] = CurrentTurn;
		checkOver();
		if (!Over) { // switch turn
			CurrentTurn = (CurrentTurn == Symbol.CIRCLE) ? (Symbol.CROSS) : (Symbol.CIRCLE);
		}
	}

	/**
	 * Scans for a win scenario and if so adds the score of that player and resets
	 */
	private void checkOver() {
		// Couldn't really think of better optimized version of this
		// diagonal checking
		if ((TileGrid[0][0] == TileGrid[1][1] && TileGrid[1][1] == TileGrid[2][2] && TileGrid[2][2] != Symbol.EMPTY)
				|| (TileGrid[0][2] == TileGrid[1][1] && TileGrid[1][1] == TileGrid[2][0]
						&& TileGrid[0][2] != Symbol.EMPTY)) {
			Over = true;
			Won = true;
			increaseScore(CurrentTurn);
			return;
		}

		// Check both rows and cols
		for (int i = 0; i < 3; i++) {
			if ((TileGrid[i][0] == TileGrid[i][1] && TileGrid[i][1] == TileGrid[i][2] && TileGrid[i][2] != Symbol.EMPTY)
					|| (TileGrid[0][i] == TileGrid[1][i] && TileGrid[1][i] == TileGrid[2][i]
							&& TileGrid[2][i] != Symbol.EMPTY)) {
				Over = true;
				Won = true;
				increaseScore(CurrentTurn);
				return;
			}
		}
		
		int smallCounter = 0;
		//terrible runtime I know, but that was not a requirement and I am tired
		for (int i = 0; i < TileGrid.length; i++) {
			for (int j = 0; j < TileGrid.length; j++) {
				if(TileGrid[i][j] == Symbol.EMPTY) {
					++smallCounter;
				}
			}
		}
		if(smallCounter == 0) {
			Over = true;
			Won = false;
		}
	}

	private void increaseScore(Symbol team) {
		if (team == Symbol.CROSS && Over) {
			++CircleScore;
		} else if (team == Symbol.CIRCLE && Over) {
			++CrossScore;
		}
	}

	/**
	 * 
	 */
	public void reset() {
		for (int i = 0; i < TileGrid.length; i++) {
			for (int j = 0; j < TileGrid.length; j++) {
				TileGrid[i][j] = Symbol.EMPTY;
			}
		}
		// Keep turn of the winning player, they start next round
		Over = false;
		Won = false;
	}

	/**
	 * Getter for each of the TTT cells
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public Symbol getTile(int row, int col) {
		return TileGrid[row][col];
	}

	/**
	 * Which turn is it?
	 * 
	 * @return
	 */
	public String getTurn() {
		if (CurrentTurn == Symbol.CROSS) {
			return "Cross";
		} else if (CurrentTurn == Symbol.CIRCLE) {
			return "Circle";
		}
		return "Nobody";
	}

	/**
	 * Score getter for the player scores
	 * 
	 * @param Team
	 * @return
	 */
	public int getScore(Symbol Team) {
		if (Team == Symbol.CIRCLE) {
			return CircleScore;
		} else if (Team == Symbol.CROSS) {
			return CrossScore;
		}
		return -1;
	}

	/**
	 * returns staye of the game
	 * 
	 * @return
	 */
	public boolean isOver() {
		return Over;
	}
	
	public boolean wasWon() {
		return Won;
	}
}
