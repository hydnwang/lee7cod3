class Solution {
    public int climbStairs(int n) {
        // Solution1: DP
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        
        // Solution2: DP with fewer memory
        int dpa = 0;
        int dp1 = 1;
        int dp0 = 1;
        for (int i = 2; i <= n; i++) {
            dpa = dp1 + dp0;
            dp0 = dp1;
            dp1 = dpa;
        }
        if (n < 2) return 1;
        return dpa;
        
        // Solution3: Recursive
        int[] mem = new int[n];
        return climb(0, n, mem);
    }
    
    private int climb(int i, int n, int[] mem) {
        // climb more than stairs
        if (i > n) return 0; 
        
        // steps match stairs, 1 possible step combination found
        if (i == n) return 1; 
        
        if (mem[i] > 0) return mem[i];
        
        mem[i] = climb(i+1, n, mem) + climb(i+2, n, mem);
        return mem[i];
    }
}