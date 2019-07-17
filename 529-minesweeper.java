/* 
reference:
https://leetcode.com/problems/minesweeper/discuss/99826/Java-Solution-DFS-+-BFS/104015
*/

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0]; int y = click[1];
        
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y);
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length) return;
        if (y < 0 || y >= board[0].length) return;
        if (board[x][y] != 'E') return;
        
        // check number of mines in adjacent slots
        int mine_cnt = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int dx = x + i;
                int dy = y + j;
                if (dx<0||dx>=board.length||dy<0||dy>=board[0].length) continue;
                if (board[dx][dy] == 'M') mine_cnt++;
            }
        }
        
        if (mine_cnt == 0) {
            board[x][y] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    dfs(board, x+i, y+j);
                }
            }
        } else {
            board[x][y] = (char)('0'+mine_cnt);
        }
    }
}