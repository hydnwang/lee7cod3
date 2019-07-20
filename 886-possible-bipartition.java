class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // because person number is starting from 1 not 0
        // shift all initial values by 1
        int[] colors = new int[N+1];
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList();
        for (int[] people : dislikes) {
            adj[people[0]].add(people[1]);
            adj[people[1]].add(people[0]);
        }
        
        for (int i = 1; i <= N; i++) {
            if (colors[i]==0 && !dfs(colors, adj, i, 1)) return false;
        }
        return true;
    }
    
    private boolean dfs(int[] colors, ArrayList<Integer>[] adj, int person, int color) {
        if (colors[person] != 0) return colors[person] == color;
        colors[person] = color;
        for (int p : adj[person]) {
            if (!dfs(colors, adj, p, -1*color)) return false;
        }
        return true;
    }
}