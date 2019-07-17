// Solution1: DFS + adjacency list
// Solution2: BFS + adjacency list
// reference: 
// 1. https://leetcode.com/problems/friend-circles/discuss/335063/Count-connected-components-DFSBFSUF-a-good-practice-for-graph-fundamentals
// 2. https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
// 3. https://leetcode.com/problems/friend-circles/discuss/101338/Neat-DFS-java-solution
// 4. https://leetcode.com/problems/friend-circles/discuss/101344/Java-BFS-Equivalent-to-Finding-Connected-Components-in-a-Graph
class Solution {
    boolean[] visited;
    Map<Integer, ArrayList<Integer>> graph;
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        visited = new boolean[n];
        graph = new HashMap<Integer, ArrayList<Integer>>(n);
        
        for (int i = 0; i < n; i++) {
            if (graph.get(i) == null) graph.put(i, new ArrayList());
            for (int j = i+1; j < n; j++) {
                if (M[i][j] == 0) continue;
                if (graph.get(j) == null) graph.put(j, new ArrayList());
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // Solution1: DFS + adjacency list
            if (!visited[i]) sum += dfs(M, i);
            
            // Solution2: BFS + adjacency list
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            if (!visited[i]) sum += bfs(M, q);
        }
        return sum;
    }
    
    private int dfs(int[][] M, int node) {
        if (!visited[node]) {
            visited[node] = true;
            for (int neighbor : graph.get(node)) {
                dfs(M, neighbor);
            }
        }
        return 1;
    }
    
    private int bfs(int[][] M, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return 1;
    }
}

// Solution3: Direct DFS
class Solution3 {
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(visited, M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(visited, M, j);
            }
        }
    }
}

// Solution4; Direct BFS
class Solution4 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                q.add(i);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    visited[n] = true;
                    for (int j = 0; j < M.length; j++) {
                        if (M[n][j] == 1 && visited[j] == false) {
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}

// Solution5: Union find w/o rank base
class Solution5 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int result = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) result++;
        }
        return result;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        parent[find(parent, y)] = find(parent, x);
    }
    
}

// Solution6: Union find w/ rank base
// ...