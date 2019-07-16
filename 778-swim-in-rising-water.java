class Solution {
    public int swimInWater(int[][] grid) {
        // Solution2: Binary Search
        // ...
        
        // Solution1: Heap
        int row = grid.length;
        int col = row;
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((x, y) -> grid[x/col][x%col]-grid[y/col][y%col]);
        Set<Integer> set = new HashSet();
        int result = 0;
        int[] dirRow = new int[]{1, -1, 0, 0};
        int[] dirCol = new int[]{0, 0, 1, -1};
        // Number each square from left to right, top to bottom.
        //  0  1  2  3
        //  4  5  6  7
        //  8  9 10 11
        // 12 13 14 15
        // real coordinate (x, y) = (#/col, #%col)
        // i.e. (5/4, 5%4) = (1, 1) for # = 5
        pq.offer(0); // put start point in queue
        
        while (!pq.isEmpty()) {
            int x = pq.poll();
            int r = x / col;
            int c = x % col;
            int elevator = grid[r][c];
            result = Math.max(result, elevator);
            if (r == row - 1 && c == col - 1) return result;
            
            for (int i = 0; i < 4; i++) {
                int dr = r + dirRow[i];
                int dc = c + dirCol[i];
                int dx = col * dr + dc;
                if (dr>=0 && dr<row && dc>=0 && dc<col && !set.contains(dx)) {
                    pq.offer(dx);
                    set.add(dx);
                }
            }
        }
        return result;
    }
}