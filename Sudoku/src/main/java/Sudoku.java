import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Sudoku {

    public static final int SIZE = 9;
    public static final int PART = 3;
    public static final int MAX_SOLUTIONS = 100;

    private int[][] grid;
    private int[][] solution;
    ArrayList<Spot> spotList;

    private int solutionsCounter;
    private long elapsedTime;

    public static int[][] stringsToGrid(String... rows) {
        int[][] result = new int[rows.length][];
        for (int row = 0; row < rows.length; row++) {
            result[row] = stringToInts(rows[row]);
        }
        return result;
    }



    public static int[][] textToGrid(String text) {
        int[] nums = stringToInts(text);
        if (nums.length != SIZE * SIZE) {
            throw new RuntimeException("Needed 81 numbers, but got:" + nums.length);
        }

        int[][] result = new int[SIZE][SIZE];
        int count = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                result[row][col] = nums[count];
                count++;
            }
        }
        return result;
    }



    public static int[] stringToInts(String string) {
        int[] a = new int[string.length()];
        int found = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                a[found] = Integer.parseInt(string.substring(i, i + 1));
                found++;
            }
        }
        int[] result = new int[found];
        System.arraycopy(a, 0, result, 0, found);
        return result;
    }



    private class Spot implements Comparable {

        private int row, col, validValsCounter;

        public Spot(int row, int col) {
            this.row = row;
            this.col = col;
            validValsCounter = getValidValues().size();
        }

        public void set(int value) {
            grid[row][col] = value;
        }

        private HashSet<Integer> getValidValues() {
            HashSet<Integer> validSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

            for (int i = 0; i < SIZE; i++) {
                validSet.remove(grid[i][col]);
                validSet.remove(grid[row][i]);
                validSet.remove(grid[row / PART * PART + i / PART][col / PART * PART + i % PART]);
            }

            return validSet;
        }

        @Override
        public int compareTo(Object elem) {
            Spot cmp = (Spot) elem;
            return this.validValsCounter - cmp.validValsCounter;
        }
    }


    public Sudoku(int[][] ints) {
        assert (ints.length == SIZE && ints[0].length == SIZE);
        grid = ints;
        solution = new int[SIZE][SIZE];
        solutionsCounter = 0;
        createSpotList();
    }

    private void createSpotList() {
        spotList = new ArrayList<Spot>();

        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                if (grid[row][col] == 0) {
                    spotList.add(new Spot(row, col));
                }

        Collections.sort(spotList);
    }

    public Sudoku(String values) {
        this(textToGrid(values));
    }

    @Override
    public String toString() {
        return toString(grid);
    }
    public int solve() {
        long startTime = System.currentTimeMillis();

        solutionHelper(0);

        long endTime = System.currentTimeMillis();

        elapsedTime = endTime - startTime;
        return solutionsCounter;
    }





    public String getSolutionText() {
        return toString(solution);
    }
    public long getElapsed() {
        return elapsedTime;
    }






    private String toString(int[][] grid) {

        String result = "";

        if (grid != null)
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    result += grid[i][j] + " ";
                result += "\n";
            }

        return result;
    }

    private void solutionHelper(int position) {

        if (solutionsCounter >= MAX_SOLUTIONS) return;


        if (position == spotList.size()) {
            if (solutionsCounter == 0)
                saveSolution();
            solutionsCounter++;
            return;
        }

        Spot currentSpot = spotList.get(position);
        HashSet<Integer> valuesSet = currentSpot.getValidValues();

        for (int value : valuesSet) {
            currentSpot.set(value);
            solutionHelper(position + 1);
            currentSpot.set(0);
        }

    }

    private void saveSolution() {
        for (int i = 0; i < SIZE; i++)
            System.arraycopy(grid[i], 0, solution[i], 0, SIZE);
    }
    public static void main(String[] args) {
        Sudoku sudoku;
        sudoku = new Sudoku(Sudoku.stringsToGrid(
                "3 7 0 0 0 0 0 8 0",
                "0 0 1 0 9 3 0 0 0",
                "0 4 0 7 8 0 0 0 3",
                "0 9 3 8 0 0 0 1 2",
                "0 0 0 0 4 0 0 0 0",
                "5 2 0 0 0 6 7 9 0",
                "6 0 0 0 2 1 0 4 0",
                "0 0 0 5 3 0 9 0 0",
                "0 3 0 0 0 0 0 5 1"));

        System.out.println(sudoku); // print the raw problem
        int count = sudoku.solve();
        System.out.println("solutions:" + count);
        System.out.println("elapsed:" + sudoku.getElapsed() + "ms");
        System.out.println(sudoku.getSolutionText());


        Sudoku sudoku2;
        sudoku2 = new Sudoku(Sudoku.stringsToGrid(
                "1 6 4 0 0 0 0 0 2",
                "2 0 0 4 0 3 9 1 0",
                "0 0 5 0 8 0 4 0 7",
                "0 9 0 0 0 6 5 0 0",
                "5 0 0 1 0 2 0 0 8",
                "0 0 8 9 0 0 0 3 0",
                "8 0 9 0 4 0 2 0 0",
                "0 7 3 5 0 9 0 0 1",
                "4 0 0 0 0 0 6 7 9"));

        System.out.println(sudoku2); // print the raw problem
        int count2 = sudoku2.solve();
        System.out.println("solutions:" + count2);
        System.out.println("elapsed:" + sudoku2.getElapsed() + "ms");
        System.out.println(sudoku2.getSolutionText());
    }

}