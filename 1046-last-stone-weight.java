class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        // pq.addAll(Arrays.asList(stones));
        for (int stone : stones) {
            pq.offer(stone);
        }
        
        while (!pq.isEmpty()) {
            int y = pq.poll();
            if (pq.isEmpty()) return y;
            int x = pq.poll();
            if (y > x) {
                pq.offer(y - x);
            }
        }       
        return 0;
    }
}