class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            List<Character> relevantchars = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                relevantchars.add(board[i][j]);
            }
            if (!checkValidity(relevantchars)) return false;
        }

        for (int i = 0; i < 9; i++) {
            List<Character> relevantchars = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                relevantchars.add(board[j][i]);
            }
            if (!checkValidity(relevantchars)) return false;
        }

        for (int sq_row = 0; sq_row < 9; sq_row += 3) {
            for (int sq_column = 0; sq_column < 9; sq_column += 3) {
                List<Character> relevantchars = new ArrayList<>();
                for (int row = sq_row; row < sq_row+3; row++) {
                    for (int column = sq_column; column < sq_column+3; column++) {
                        relevantchars.add(board[row][column]);
                    }  
                    if (!checkValidity(relevantchars)) return false;
                }
            }
        }

        return true;
    } 

    public boolean checkValidity(List<Character> section) {
        List<Character> existing = new ArrayList<>();
        for (char s : section) {
            if (existing.contains(s)) return false;
            if (s >= '0' && s <= '9') existing.add(s);
        }
        return true;
    }
}
