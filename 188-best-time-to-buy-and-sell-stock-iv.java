// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment/55651
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        // corner case:
        // we can make as many transactions as we want
        if (k >= n / 2) { 
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }
        
        // dp[i][j]: max profit by making at most i transactions on day j
        // dp[0][j]: make 0 transaction, 0 profit
        // dp[i][0]; we can only buy stock on the first day
        
        int[][] dp = new int[k+1][n];
        
        for (int i = 1; i <= k; i++) {
            
            // reset local max for each value of k
            int localMax = Integer.MIN_VALUE;
            
            for (int j = 1; j < n; j++) {
                // local max is the previous max profit for transaction (i-1) 
                // on previous day (j-1) and buy stock on day(j-1)
                localMax = Math.max(localMax, dp[i-1][j-1] - prices[j-1]);
                
                // current global max profit is either 
                // 1. we don't sell stock on day j (remain the same as dp[i][j-1]) or
                // 2. we sell stock on day j plus our local max profit
                dp[i][j] = Math.max(dp[i][j-1], localMax + prices[j]);
            }
        }
        return dp[k][n-1];
    }
}