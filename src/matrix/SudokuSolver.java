package matrix;

import java.util.HashSet;

public class SudokuSolver {
    public static void main(String[] args) {
        String[][] board = new String[][]{
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};

        System.out.println(validSudoku(board));

    }

    private static boolean validSudoku(String[][] board) {
        int N = 9;

        HashSet<String>[] rows = new HashSet[N];
        HashSet<String>[] cols = new HashSet[N];
        HashSet<String>[] boxes = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                String val = board[r][c];

                // Check if the position is filled with number
                if (val.equals(".")) {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
