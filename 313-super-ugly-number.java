class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new Set<>();
        
        pq.offer(1);
        for (int p : primes) {
            pq.offer(p);
        }
        
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = pq.poll();
            if (val == 1) continue;
            
            System.out.println(val);
            
            for (int p : primes) {
                pq.offer(val*p);
            }
        }
        return val;
    }
}