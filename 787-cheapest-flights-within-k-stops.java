class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // int n = flight.length;
        // create a adjacency list for each src along with its dst and price
        Map<Integer, Map<Integer, Integer>> adj = new HashMap();
        for (int[] f : flights) {
            int start = f[0];
            int dest = f[1];
            int price = f[2];
            if (!adj.containsKey(start)) adj.put(start, new HashMap());
            adj.get(start).put(dest, price);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // store [price, city, k_stop_needed] in queue
        pq.offer(new int[]{0, src, K+1});
        
        while (!pq.isEmpty()) {
            int[] cityStatus = pq.poll();
            int price = cityStatus[0];
            int city = cityStatus[1];
            int stops = cityStatus[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adjCities = adj.getOrDefault(city, new HashMap());
                for (int c : adjCities.keySet()) {
                    pq.offer(new int[]{price+adjCities.get(c), c, stops-1});
                }
            }
        }
        return -1;
    }
}