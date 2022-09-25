package backtracking;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        // Traversing a graph involves two ways
        // 1. Depth first, 2. Breath first

        // sudoku board
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}};

        if (solve(board)) {
            System.out.println("Sudoku board was solved successfully");
        } else {
            System.out.println("Board not solved, there might be a problem with the board placements");
        }

        printBoard(board);
    }

    // method to print board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0) {
                System.out.println("-----------");
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean possible(int[][] board, int row, int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number)
                return false;
        }

        for (int j = 0; j < GRID_SIZE; j++) {
            if (board[j][col] == number)
                return false;
        }

        int newRow = (row / 3) * 3;
        int newCol = (col / 3) * 3;

        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newCol; j < newCol + 3; j++) {
                if (board[newRow][newCol] == number)
                    return false;
            }
        }

        return true;
    }
    // helper method that tells you whether a row contains a number
    private static boolean isNumberInRow (int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    // helper method that tells you whether a column contains a number
    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }

    // helper method that tells you whether the row and column of a box contains a number
    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = (row / 3) * 3; //row - row % 3;
        int localBoxColumn = (column / 3) * 3; //column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    // helper method that tells you whether the three methods above return true
    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return isNumberInRow(board, number, row) &&
                isNumberInColumn(board, number, column) &&
                isNumberInBox(board, number, row, column);
    }

    private static boolean solve(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    // solve/fill this cell by choosing a number between 1 and 9
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (possible(board, i, j, num)) {
                            board[i][j] = num;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    // If we can solve the board, then we return false.
                    return false;
                }
            }
        }
        return true;
    }

    // method to solve the sudoku problem
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (possible(board, row, col, numberToTry)) {
                            board[row][col] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            }else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false; // the board is not correct
                }
            }
        }
        return true;
    }
}