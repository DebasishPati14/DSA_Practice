package com.recursion;

public class N_Queens {
	public static void main(String[] args) {
		int num = 4;
		int[][] chessBoard = new int[num][num];
		findN_queenSolution(chessBoard, 0, "");
	}

	private static void findN_queenSolution(int[][] chessBard, int row, String queenPlacedValue) {
		if (row == chessBard.length) {
			System.out.println(queenPlacedValue);
			return;
		}

		for (int col = 0; col < chessBard.length; col++) {
			if (isSafePlaceForQueen(chessBard, row, col)) {
				chessBard[row][col] = 1;
				findN_queenSolution(chessBard, row + 1, queenPlacedValue + row + "-" + col + ", ");
				chessBard[row][col] = 0;
			}
		}
	}

	public static boolean isSafePlaceForQueen(int[][] chessBoard, int row, int col) {

		// Vertical row verification
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}

		// Left row verification
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}

		// Right row verification
		// System.out.println("Point: " + i + "," + j);
		for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
			if (chessBoard[i][j] == 1) {
				return false;
			}
		}

		return true;
	}
}
