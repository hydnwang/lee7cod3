class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int[] sum = new int[n]; // ith: sum of 0 ~ ith
        sum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            // if accumulated sum + current num is smaller
            // than current num, then obviously previous sum
            // is useless, reset the sum to current number.
            sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
            
            // compare local max with global max
            max = Math.max(sum[i], max);
        }
        return max;
    }
}