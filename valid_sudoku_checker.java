import java.util.*;

public class valid_sudoku_checker {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                if (rows[r].contains(val)) return false;
                rows[r].add(val);

                if (cols[c].contains(val)) return false;
                cols[c].add(val);

                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex].contains(val)) return false;
                boxes[boxIndex].add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter 9 rows of Sudoku (digits 1-9 or '.' for empty):");

        // Read one row at a time (like C++)
        for (int i = 0; i < 9; i++) {
            String row = sc.next();  // read row string
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        if (isValidSudoku(board)) {
            System.out.println("The Sudoku board is VALID");
        } else {
            System.out.println("The Sudoku board is INVALID");
        }

        sc.close();
    }
}
