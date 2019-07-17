class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // ArrayList<Integer> visited = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet();
        // Solution1 DFS
        dfs(rooms, 0, visited);

        // Solution2 BFS
        bfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }
    
    private void dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        if (visited.contains(room)) return;
        visited.add(room);
        for (int r : rooms.get(room)) {
            dfs(rooms, r, visited);
        }
    }
    
    private void bfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        Queue<Integer> q = new ArrayDeque();
        q.offer(room);
        while (!q.isEmpty()) {
            int r = q.poll();
            visited.add(r);
            if (visited.size() == rooms.size()) return;
            for (int other : rooms.get(r)) {
                if (!visited.contains(other)) {
                    q.offer(other);
                }
            }
        }
    }
}