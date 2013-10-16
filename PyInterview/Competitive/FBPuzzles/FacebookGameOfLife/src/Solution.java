package PyInterview.Competitive.FBPuzzles.FacebookGameOfLife.src;

import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	
	public static int numTestCases = 0;
	public static int sizeBoard = 0;
	public static int numIterations = 0;
	public static ArrayList<String[][]> boards = null;
	
	public static void main(String[] args) {
		// Parse the stdin
		Parser parse = new Parser();
		numTestCases = parse.numTestCases;
		sizeBoard = parse.sizeBoard;
		numIterations = parse.numIterations;
		boards = parse.getBoards();
		
		// For each tile, look at each tile in the 3x3 grid centered at that tile. 
		// If there are more black tiles than white tiles, make the tile black. 
		// Otherwise, make the tile white. The tiles on the boundary 
		// of the board never change colors.
		
		// So our actions dont affect other tiles in this iteration
		
		for (int p = 0; p < boards.size(); p++) {
			for (int z = 0; z < numIterations; z++) {
				String[][] cloneBoard = boards.get(p).clone();
				for (int i = 0; i < boards.get(p).length; i++) {
					for (int j = 0; j < boards.get(p).length; j++) {
						ArrayList<String> adjacents = new ArrayList<String>();;
						// Tile is on the boundary
						if (i == 0 || j == 0 || i == sizeBoard - 1 || j == sizeBoard - 1) 
							continue;
						else {
							if (isValidTile(i-1, j-1))
								adjacents.add(boards.get(p)[i-1][j-1]);
							if (isValidTile(i, j-1))
								adjacents.add(boards.get(p)[i][j-1]);
							if (isValidTile(i+1, j-1))
								adjacents.add(boards.get(p)[i+1][j-1]);
							if (isValidTile(i-1, j))
								adjacents.add(boards.get(p)[i-1][j]);
							if (isValidTile(i, j))
								adjacents.add(boards.get(p)[i][j]);
							if (isValidTile(i+1, j))
								adjacents.add(boards.get(p)[i+1][j]);
							if (isValidTile(i-1, j+1))
								adjacents.add(boards.get(p)[i-1][j+1]);
							if (isValidTile(i, j+1))
								adjacents.add(boards.get(p)[i][j+1]);	
							if (isValidTile(i+1, j+1))
								adjacents.add(boards.get(p)[i+1][j+1]);
						}
						
						int numWhite = 0;
						int numBlack = 0;
						for (int m = 0; m < adjacents.size(); m++) {
							if (adjacents.get(m).equals("w"))
								numWhite++;
							else
								numBlack++;
						}
						if (numBlack > numWhite) {
							cloneBoard[i][j] = "b";
						}
						else
							cloneBoard[i][j] = "w";
					}
				}
				// Flip the tiles
				boards.set(p, cloneBoard);
			}
		}
		
		int boardNumber = 1;
		String printString = "";
		for (int w = 0; w < boards.size(); w++) {
			printString += "Board " + Integer.toString(boardNumber) + "\r\n";
			for (int y = 0; y < boards.get(w).length; y++) {
				for (int r = 0; r < boards.get(w).length; r++) {
					printString += boards.get(w)[y][r];
				}
				printString += "\r\n";
			}
			boardNumber++;
		}
		System.out.println(printString);
	}
	
	public static boolean isValidTile(int i, int j) {
		if (i >= 0 && i < sizeBoard && j >= 0 && j < sizeBoard)
			return true;
		return false;
	}
}

class Parser {
	Scanner ss = new Scanner(System.in);
	int lineNumber = 0;
	int numTestCases = 0;
	int sizeBoard = 0;
	int numIterations = 0;
	ArrayList<String[][]> boards = new ArrayList<String[][]>();
	//String[][] board = null;
			
	public Parser() {
		boolean nonJump = true;
		while (ss.hasNextLine() && nonJump) {
			if (lineNumber == 0)
				numTestCases = Integer.parseInt(ss.nextLine());
			else if (lineNumber == 2) {
				String line = ss.nextLine();
				Scanner disect = new Scanner(line);
				sizeBoard = Integer.parseInt(disect.next());
				numIterations = Integer.parseInt(disect.next());
				disect.close();
				nonJump = false;
			}
			lineNumber++;
		}

		int rowNumber = 0;
		int colNumber = 0;
		String[][] board = new String[sizeBoard][sizeBoard];
		for (int i = 0; i < sizeBoard; i++) {
			String row = ss.nextLine();
			Scanner disect = new Scanner(row);
			
			disect.useDelimiter("");
			while(disect.hasNext()) {
				String chara = disect.next();
				board[rowNumber][colNumber] = chara;
				colNumber++;
			}
			rowNumber++;
			colNumber = 0;
			disect.close();
		}
		
		boards.add(board);
		// Skip the first one we already did
		for (int u = 1; u < numTestCases; u++) {
			String[][] bboard = new String[sizeBoard][sizeBoard];
			int rrNum = 0;
			int ccNum = 0;
			for (int i = 0; i < sizeBoard && ss.hasNextLine(); i++) {
				String row = ss.nextLine();
				Scanner disect = new Scanner(row);
				disect.useDelimiter("");
				while(ss.hasNext()) {
					bboard[rrNum][ccNum] = disect.next();
					colNumber++;
				}
				rowNumber++;
				disect.close();
			}
			boards.add(bboard);
		}
	}
	
	public ArrayList<String[][]> getBoards() {
		return boards;
	}
	
}

