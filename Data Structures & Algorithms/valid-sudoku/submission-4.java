class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solution1_bruteForce(board);
    }

    public boolean solution1_bruteForce(char[][] board) {
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
