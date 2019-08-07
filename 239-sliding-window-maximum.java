// Refer to:
// https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation/67921

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        
        // Deque: store indices of numbers
        Deque<Integer> dq = new LinkedList();
        // Result only has length: n - k + 1
        int[] res = new int[n-k+1];
        
        for (int i = 0; i < n; i++) {
            int currentHeadIdx = i - k + 1;
            // current head index is larger than the most front
            // index stored in deque, remove the index cuz it's useless
            if (!dq.isEmpty() && i-k+1 > dq.peek()) {
                dq.poll();
            }
            
            // if the number of current index is larger than
            // the last (smallest) number in deque, removing it
            // and keep removing any number that is smaller than current number
            // since we only need the largest number within current index range
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            // push index of new number
            dq.offer(i);
            
            // if current head idx is positioned larger or equal 0
            // start update our result for max sliding window
            if (currentHeadIdx >= 0) {
                res[currentHeadIdx] = nums[dq.peek()];
            }
        }
        return res;
    }
}