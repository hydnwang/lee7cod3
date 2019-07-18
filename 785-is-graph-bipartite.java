class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // default 0, represent unvisited; 1 and -1 represent 2 colors
        
        // DFS
        for (int i = 0; i < n; i++) {
            // only traverse unvisited nodes
            if (colors[i] == 0 && !dfs(graph, colors, 1, i))
                return false;
        }
        return true;
        
        
        // BFS
        Queue<Integer> q = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            q.offer(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int parent = q.poll();
                for (int node : graph[parent]) {
                    if (colors[node] == 0) {
                        colors[node] = -1 * colors[parent];
                        q.offer(node);
                    } else if (colors[node] == colors[parent]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int color, int node) {
        // if node is visited, it must has diferent color from its parent
        if (colors[node] != 0) return colors[node] == color;
        
        colors[node] = color;
        
        // check all paths, return true when all the paths are true for sure.
        for (int n : graph[node]) {
            if (!dfs(graph, colors, -1*color, n)) return false;
        }
        return true;
    }
}