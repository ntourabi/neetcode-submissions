class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solution2_singlePass(board);
    }

    public int translate(int row, int column) {
        return (row / 3) * 3 + (column / 3);
    }

    public boolean solution2_singlePass(char[][] board) {
        //Set up data structures.
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        //Inspect every cell.
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                    char entry = board[r][c];
                    int b = translate(r, c);
                    if (rows[r].contains(entry)) {
                        System.out.println("Failed. Row");
                    } else if (columns[c].contains(entry)) {
                        System.out.println("Failed. Column");
                    } else if (boxes[b].contains(entry)) {
                        System.out.println("Failed. Box.");
                        System.out.println(b);
                        System.out.println(r);
                        System.out.println(c);
                    }
                    if (rows[r].contains(entry) || columns[c].contains(entry) || boxes[b].contains(entry)) return false;
                    
                    if (entry != '.') {
                        rows[r].add(entry);
                        columns[c].add(entry);
                        boxes[b].add(entry);
                    }
            }
        }
        return true;
    }

    public boolean solution1_semiOptimal(char[][] board) {
        //[row][column]
        Set<Character> seen;
        //Are all rows valid?
        for (char[] row : board) {
            seen = new HashSet<>();
            for (char entry : row) {
                if (seen.contains(entry)) return false;
                if (entry != '.') seen.add(entry);
            }
        }
        //Are all columns valid?
        for (int column = 0; column < board.length; column++) {
            seen = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                char entry = board[row][column];
                if (seen.contains(entry)) return false;
                if (entry != '.') seen.add(entry);
            }
        }
        //Are all 3x3 boxes valid?
        for (int row = 0; row < board.length; row += 3) {
            for (int column = 0; column < board.length; column += 3) {
                seen = new HashSet<>();
                for (int i = row; i < (row+3); i++) {
                    for (int j = column; j < (column+3); j++) {
                        char entry = board[i][j];
                        if (seen.contains(entry)) return false;
                        if (entry != '.') seen.add(entry);
                    }
                }
            }
        }
        //We've checked it all, must be true. 
        return true;
    }
}
