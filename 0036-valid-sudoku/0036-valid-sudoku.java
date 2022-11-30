class Solution {
    int subno(int row, int col) {
        return (3 * (row / 3)) + (col / 3);
    }
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> subs = new ArrayList<HashSet<Character>>();
        for(int i=0; i<9; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            subs.add(new HashSet<Character>());
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(rows.get(i).contains(board[i][j])) return false;
                    else rows.get(i).add(board[i][j]);
                    if(cols.get(j).contains(board[i][j])) return false;
                    else cols.get(j).add(board[i][j]);
                    int sub = subno(i, j);
                    if(subs.get(sub).contains(board[i][j])) return false;
                    else subs.get(sub).add(board[i][j]);
                }
            }
        }
        return true;
    }
}