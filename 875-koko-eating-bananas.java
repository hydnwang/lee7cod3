class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1; // lower bound of k
        int hi = 1000000000; // upper bound of k: 10^9
        int k = 0;
        
        while (lo < hi) {
            k = lo + (hi - lo) / 2;
            // H * k >= # Banana
            // => k >= ceil( sum(piles[i]) / H );
            // => H >= ceil( sum(piles[i]) / k );
            int sumTime = 0;
            for (int p : piles) {
                sumTime += (p - 1) / k + 1; // calculate ceil everytime
            }
            if (sumTime > H) { // eat too slow
                lo = k + 1;
            } else {
                hi = k;
            }
        }
        return lo;
    }
}