package game;

enum Symbol {
	EMPTY, CIRCLE, CROSS;
}

/**
 * Diego's super cool TicTacToe game that he programmed because engineering!
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
	 * @param row
	 * @param col
	 */
	public void claimTile(int row, int col) {
		if (row > 2 || col > 2 || Over) {
			return;
		}
		if (TileGrid[row][col] == Symbol.EMPTY) {
			TileGrid[row][col] = CurrentTurn;
			checkOver();
			if (!Over) {
				switchTurn();
				System.out.println("this is:" + row + col);
			}
		}
	}
	
	/**
	 * Scans for a win scenario and if so adds the score of that player and resets
	 */
	private void checkOver() {
		// Couldn't really think of better optimized version of this
		// Check both rows and cols
		/*for (int i = 0; i < TileGrid.length; i++) {
			if ((TileGrid[i][0] == TileGrid[i][1] && TileGrid[i][1] == TileGrid[i][2])
					|| (TileGrid[0][i] == TileGrid[1][i] && TileGrid[1][i] == TileGrid[2][i])) {
				Over = true;
			}
		}
		//diagonal checking
		if((TileGrid[0][0] == TileGrid[1][1] && TileGrid[1][1] == TileGrid[2][2])
				|| (TileGrid[0][3] == TileGrid[1][1] && TileGrid[1][1] == TileGrid[3][0])) {
			Over = true;
		}
		if(Over) {
			if(CurrentTurn == Symbol.CROSS) {
				++CircleScore;
			}
			else if(CurrentTurn == Symbol.CIRCLE) {
				++CrossScore;
			}
			for (int i = 0; i < TileGrid.length; i++) {
				for (int j = 0; j < TileGrid.length; j++) {
					TileGrid[i][j] = Symbol.EMPTY;
				}
			}
			//Keep turn of the winning player, they start next round
		}*/
	}

	/**
	 * Switch control to the next player
	 */
	private void switchTurn() {
		CurrentTurn = (CurrentTurn == Symbol.CIRCLE) ? (Symbol.CROSS) : (Symbol.CIRCLE);
	}

	/**
	 * Getter for each of the TTT cells
	 * @param row
	 * @param col
	 * @return
	 */
	public Symbol getTile(int row, int col) {
		return TileGrid[row][col];
	}

	/**
	 * Score getter for the player scores
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
}
