class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int count = -1;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                for (int[] d : dir) {
                    int x = node[0] + d[0];
                    int y = node[1] + d[1];
                    if (x<0||y<0||x>=row||y>=col) continue;
                    if (grid[x][y]==2||grid[x][y]==0) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    fresh--;
                }
            }
        }
        if (fresh > 0) return -1;
        return count;
    }
}