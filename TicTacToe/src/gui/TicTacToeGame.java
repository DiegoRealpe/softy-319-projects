package gui;

enum Symbol{
	EMPTY, CIRCLE,CROSS;
}

public class TicTacToeGame {
	
	private Symbol TileGrid[][] = new Symbol[3][3];
	
	//Cross starts first
	private Symbol CurrentTurn = Symbol.CROSS;

	private int CrossScore;
	private int CircleScore;
	private boolean Over;
	

	public TicTacToeGame() {
		for (int i = 0; i < TileGrid.length; i++) {
			for (int j = 0; j < TileGrid.length; j++) {
				TileGrid[i][j] = Symbol.EMPTY;
			}
		}
	}
	
	public void claimTile(int row, int col) {
		if(row > 2 || col > 2 || Over) {
			return;
		}
		if(TileGrid[row][col] == Symbol.EMPTY) {
			TileGrid[row][col] = CurrentTurn;
			checkOver();
			switchTurn();
		}
	}
	
	public void checkOver() {
		//Couldn't really think of better optimized version of this
		//Check both rows and cols
		int rowRun, colRun, diaRun = 0;
		for (int i = 0; i < TileGrid.length; i++) {
			if(TileGrid[i][0] == TileGrid[i][1] && TileGrid[i][1] == TileGrid[i][2]) {
				//person who had turn is always gonna win
				Over = true;
			}
			if(TileGrid[0][i] == TileGrid[1][i] && TileGrid[1][i] == TileGrid[2][i]) {
						
			}
		}
	}
	
	public void switchTurn() {
		CurrentTurn = (CurrentTurn == Symbol.CIRCLE)? (Symbol.CROSS) : (Symbol.CIRCLE);
	}
	
	public Symbol getTile(int row, int col) {
		return TileGrid[row][col];
	}
	
	public int getScore(Symbol Team) {
		if(Team == Symbol.CIRCLE) {
			return CircleScore;
		}
		else if(Team == Symbol.CROSS) {
			return CrossScore;
		}
		return -1;
	}
}
