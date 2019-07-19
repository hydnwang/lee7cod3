// Solution: in-degree
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int visitCnt = 0;
        int[] res = new int[n];
        int[] inDeg = new int[n];
        Queue<Integer> q = new LinkedList();
        
        // create adjacency list for relation graph
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
        
        for (int[] courses : prerequisites) {
            inDeg[courses[0]]++;
            adj[courses[1]].add(courses[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int pre = q.poll();
            
            res[visitCnt] = pre;
            visitCnt++;
            if (visitCnt == n) return res;
            
            for (int c : adj[pre]) {
                // this line is used to prevent circles
                // if (inDeg[c] <= 0) continue;
                inDeg[c]--;
                if (inDeg[c] == 0) q.offer(c);
            }
        }
        return new int[0];
    }
}