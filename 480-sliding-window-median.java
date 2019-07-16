class Solution {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n-k+1];
        
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= k) remove(nums[i-k]);
            if (i >= k-1) res[i-k+1] = median();
        }
        return res;
    }
    
    void add(long x) {
        maxHeap.offer(x);
        minHeap.offer(maxHeap.poll());
    }
    
    void remove(long x) {
        // if number are duplicate, we delete only one from either queue.
        if (maxHeap.remove(x)) return;
        minHeap.remove(x);
    }
    
    double median() {
        while (maxHeap.size() - minHeap.size() >= 2) minHeap.offer(maxHeap.poll());
        while (minHeap.size() - maxHeap.size() >= 1) maxHeap.offer(minHeap.poll());
        
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}