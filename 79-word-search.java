class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int x, int y, int idx) {
        
        if (idx == word.length()) return true;
        if (x<0 || x>=board.length || y<0 || y>=board[0].length) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        char temp = board[x][y];
        board[x][y] = '@';
        // boolean res = false;
        // res |= dfs(board, word, x-1, y, idx+1);
        // res |= dfs(board, word, x+1, y, idx+1);
        // res |= dfs(board, word, x, y-1, idx+1);
        // res |= dfs(board, word, x, y+1, idx+1);
        boolean res = dfs(board, word, x-1, y, idx+1)
            || dfs(board, word, x+1, y, idx+1)
            || dfs(board, word, x, y-1, idx+1)
            || dfs(board, word, x, y+1, idx+1);
        board[x][y] = temp;
        return res;
    }
}