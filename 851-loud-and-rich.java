class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
        for (int[] person : richer) {
            int rich = person[0];
            int poor = person[1];
            adj[poor].add(rich);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(adj, res, quiet, i);
        }
        
        return res;
    }
    
    private int dfs(ArrayList<Integer>[] adj, int[] res, int[] quiet, int poor) {
        if (res[poor] != -1) return res[poor];
        
        res[poor] = poor; // at least themselves
        
        for (int richer : adj[poor]) {
            int childRicher = dfs(adj, res, quiet, richer);
            if (quiet[res[poor]] > quiet[childRicher]) {
                res[poor] = childRicher;
            }
        }
        return res[poor];
    }
}