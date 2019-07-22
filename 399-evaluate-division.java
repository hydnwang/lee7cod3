class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        // TODO: Solution2: Union-find
        // 
        
        // Solution1: DFS
        // Refer to solution:
        // http://zxi.mytechroad.com/blog/graph/leetcode-399-evaluate-division/
        // step1: Establish graph
        Map<String, HashMap<String, Double>> graph = new HashMap();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double k = values[i];
            // TODO: use computeIdAbsent
            if (!graph.containsKey(a)) graph.put(a, new HashMap<String, Double>());
            if (!graph.containsKey(b)) graph.put(b, new HashMap<String, Double>());
            graph.get(a).put(b, k);
            graph.get(b).put(a, 1/k);
        }
        
        // step2: find paths for each query
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || ! graph.containsKey(b)) {
                res[i] = -1.0;
            } else {
                HashSet<String> visited = new HashSet<String>();
                visited.add(a);
                res[i] = dfs(graph, a, b, visited);
            }
        }
        return res;
    }
    
    private double dfs(Map<String, HashMap<String, Double>> g, String a, String b, HashSet<String> visited) {
        // One divided by oneself is itself
        if (a.equals(b)) return 1.0;
        if (!g.containsKey(a)) return -1.0;
        
        for (String next : g.get(a).keySet()) {
            if (visited.contains(next)) continue;
            visited.add(next);
            double sum = dfs(g, next, b, visited);
            // a/b = a/next1 * next1/next2 * next2/b * b/b
            if (sum != -1.0) return sum * g.get(a).get(next);
        }
        return -1.0;
    }
}