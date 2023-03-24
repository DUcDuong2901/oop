// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 *
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 *
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minRow = Integer.MAX_VALUE;
		int maxRow = Integer.MIN_VALUE;
		int minCol = Integer.MAX_VALUE;
		int maxCol = Integer.MIN_VALUE;


		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == ch) {

					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
				}
			}
		}


		if (minRow == Integer.MAX_VALUE || minCol == Integer.MAX_VALUE) {
			return 0;
		}


		int width = maxCol - minCol + 1;
		int height = maxRow - minRow + 1;


		if (width == 1 && height == 1) {
			return 1;
		}


		return width * height;
	}


	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 *
	 * @return number of + in grid
	 */

		public int countPlus(char[][] grid) {
			int count = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (isPlus(grid, i, j)) {
						count++;
					}
				}
			}
			return count;
		}

		private static boolean isPlus(char[][] grid, int row, int col) {
			char center = grid[row][col];
			int len = 0;

			// Check horizontal branch to the right
			for (int c = col + 1; c < grid[row].length; c++) {
				if (grid[row][c] == center) {
					len++;
				} else {
					break;
				}
			}
			// Check horizontal branch to the left
			for (int c = col - 1; c >= 0; c--) {
				if (grid[row][c] == center) {
					len++;
				} else {
					break;
				}
			}
			// Check vertical branch downwards
			for (int r = row + 1; r < grid.length; r++) {
				if (grid[r][col] == center) {
					len++;
				} else {
					break;
				}
			}
			// Check vertical branch upwards
			for (int r = row - 1; r >= 0; r--) {
				if (grid[r][col] == center) {
					len++;
				} else {
					break;
				}
			}

			return len >= 2 && len % 2 == 0;
		}
	}




