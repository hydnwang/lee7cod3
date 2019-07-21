// Refer to solution:
// https://leetcode.com/problems/bus-routes/discuss/122712/Simple-Java-Solution-using-BFS
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        int res = 0;
        if (S==T) return res;
        
        Set<Integer> taken = new HashSet();
        Queue<Integer> q = new LinkedList();
        Map<Integer, ArrayList<Integer>> routeMap = new HashMap();
        
        // create graph:
        // ex: {stop1: {bus1, bus2}, stop2: {bus1, bus3, bus4}, ...}
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                ArrayList<Integer> buses = 
                    routeMap.getOrDefault(stop, new ArrayList());
                buses.add(route);
                routeMap.put(stop, buses);
            }
        }
        
        // start from first bus stop
        q.offer(S);
        
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int stop = q.poll();
                ArrayList<Integer> buses = routeMap.get(stop);
                for (int route : buses) { 
                    // don't take the same bus again
                    if (taken.contains(route)) continue;
                    taken.add(route);
                    for (int s : routes[route]) {
                        if (s == T) return res;
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}