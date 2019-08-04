class Solution {
    public boolean canPartition(int[] nums) {
        // Solution1: it basically the knapsack problem
        // https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
        int sum = 0;
        int n = nums.length;
        for (int num : nums) sum += num;
        // sum cannot be splitted evenly
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        
        // dp[i][j] represents whether 0~i-1 numbers can reach
        // weight capacity j
        boolean[][] dp = new boolean[n+1][target+1];
        
        for (int i = 1; i <= n; i++) dp[i][0] = true;
        for (int j = 1; j <= target; j++) dp[0][j] = false;
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // if don't pick current number
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][target];
        
        
        // Solution2: optimizing to save space
        // https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation/94996
        int sum = 0;
        int n = nums.length;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : nums) {
            // here is the trick to save space
            // because we have to update dp[j] based on 
            // previous dp[j-num] and dp[j] from previous loop.
            // if we update dp from left to right
            // we first update smaller dp which is dp[j-num]
            // then we won't be able to get original dp[j-num] and dp[j]
            // from previous loop, and eventually we get the wrong
            // answer. But if we update dp from right to left
            // we can assure everything is based on previous state
            for (int j = target; j >= num; j--) {
                // if (j >= num) {
                dp[j] = dp[j] || dp[j-num];
                // }
            }
        }
        return dp[target];
    }
}