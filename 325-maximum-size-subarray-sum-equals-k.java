// Refer to:
// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77784/O(n)-super-clean-9-line-Java-solution-with-HashMap/82054
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0; 
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) { 
                // the first time we found sum == target sum k
                maxLength = i + 1;
            } else if (map.containsKey(sum-k)) {
                // index of (sum-k) to current index i
                // increase the exactly the sum k, 
                // that means we found another subarray that meets our requirement,
                // so we check if we should update the max length
                maxLength = Math.max(maxLength, i-map.get(sum-k));
            }
            
            if (!map.containsKey(sum)) {
                // update (sum, index) map for later use
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}