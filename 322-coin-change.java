class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // Solution2: Dynamic Programming
        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        
        dp[0] = 0; // number of coin is 0 when amount is 0
        
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], dp[a-coin]+1);
                }
            }
        }
        
        if (dp[amount] > amount) { 
            // dp[amount] = amount + 1
            // which means it wasn't modified
            return -1;
        } else {
            return dp[amount];
        }
        
        // Solution1: Recursive with memoization
        // array numberOfCoins is used to store fewest numbers of coins 
        // correspoding to every number of amount from 0 to amount
        // so we can save plenty of time repeating same works.
        int[] numberOfCoins = new int[amount];
        return dfs(coins, amount, numberOfCoins);
    }
    
    private int dfs(int[] coins, int amount, int[] numberOfCoins) {
        if (amount < 0) return -1; // this is not the result we need;
        if (amount == 0) return 0; // one level upper this one is one of the answer
        
        // final answer is modified and stored
        if (numberOfCoins[amount-1]!= 0) return numberOfCoins[amount-1];
        
        int min = Integer.MAX_VALUE;
        // try all the coin values for current remaining amount
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, numberOfCoins);
            if (res >= 0 && res < min) {
                // ex. if we reach the end of right path
                // res returned from next level is 0, 
                // so we know we successfully add 1 and only 1 coin
                // to our number of coins, that's why we plus 1
                min = res + 1; 
            }
        }
        
        if (min != Integer.MAX_VALUE) { // answer is found
            numberOfCoins[amount-1] = min;
        } else {
            numberOfCoins[amount-1] = -1;
        }
        return numberOfCoins[amount-1];
    }
}