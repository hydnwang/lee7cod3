class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        // Solution3: Greedy backward check
        int maxReachableDistance = n-1;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] + i >= maxReachableDistance) {
                maxReachableDistance = i;
            }
        }
        return maxReachableDistance <= 0;
        
        // Solution2: Greedy forward check
        int maxReachableDistance = 0;
        for (int i = 0; i < n; i++) {
            if (maxReachableDistance < i) return false;
            maxReachableDistance = Math.max(maxReachableDistance, nums[i]+i);
        }
        return true;
        
        // Solution1: DP, runtime: 162ms, beat 27.88%
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (reachable[j] && nums[j]+j>=i) {
                    // reachable[i] = (reachable[i-1] && (nums[i-1] + i - 1 >= i));
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[n-1];
    }
}