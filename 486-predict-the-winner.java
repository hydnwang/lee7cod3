class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // define dp[i][j] as for range (i, j) , 
        // the max score player 1 can win over player2
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}