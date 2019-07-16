class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = weights[0]; // capacity lower bound
        int hi = 0;          // capacity upper bound
        // update both bounds
        for (int w : weights) { 
            if (w > lo) lo = w;
            hi += w;
        }
        
        int mid, load, d;
        
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            load = mid;
            d = 1;
            for (int w : weights) {
                if (load - w < 0) {
                    d++;
                    load = mid;
                }
                load -= w;
            }
            
            if (d > D) { // too less weight
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}