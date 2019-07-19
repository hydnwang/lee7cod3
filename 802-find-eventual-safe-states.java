class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        
        // use array of integer to represent status of each node:
        // 0: unvisited, 1: safe, 2: unsafe
        int[] status = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if(dfs(graph, status, i)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean dfs(int[][] graph, int[] status, int node) {
        
        if (status[node] != 0) return status[node] == 1;
        
        // we first mark visited node as 2, and if later we see it again
        // this is unsafe, remain status: 2, 
        // if we don't see it anymore from current path, mark it as 1
        // which is a safe node
        status[node] = 2;
        for (int next : graph[node]) {
            if (!dfs(graph, status, next)) return false;
        }
        status[node] = 1;
        return true;
    }
}