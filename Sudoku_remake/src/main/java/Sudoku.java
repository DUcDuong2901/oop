

public class Sudoku {
    private int[][] grid;

    public Sudoku(int[][] grid) {
        this.grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public static int[][] stringsToGrid(String s0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        int[][] grid = new int[9][9];
        String[] strings = {s0, s1, s2, s3, s4, s5, s6, s7, s8};
        for (int i = 0; i < 9; i++) {
            String[] row = strings[i].split(" ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        return grid;
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isValid(row, col, number)) {
                            grid[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int number) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == number) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == number) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
    public int[][] getGrid() {
        int[][] result = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = grid[i][j];
            }
        }
        return result;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(grid[i][j]);
                if (j < 8) {
                    sb.append(' ');
                }
            }
            if (i < 8) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] Grid = Sudoku.stringsToGrid(
                "3 7 0 0 0 0 0 8 0",
                "0 0 1 0 9 3 0 0 0",
                "0 4 0 7 8 0 0 0 3",
                "0 9 3 8 0 0 0 1 2",
                "0 0 0 0 4 0 0 0 0",
                "5 2 0 0 0 6 7 9 0",
                "6 0 0 0 2 1 0 4 0",
                "0 0 0 5 3 0 9 0 0",
                "0 3 0 0 0 0 0 5 1");
        Sudoku sudoku = new Sudoku(Grid);
        sudoku.solve();
        System.out.println(sudoku);
    }



}
