// Refer to:
// https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        // dp[i] represent the minimum height from books[0] to books[i-1]
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            // situation1: i-1th book should be placed on a new level itself
            dp[i] = dp[i - 1] + height;
            // situation2: i-1th book is placed with few previous books
            // depending on the width
            for (int j = i - 1; j > 0; j--) {
                width += books[j - 1][0];
                height = Math.max(height, books[j - 1][1]);
                if (width > shelf_width) break;
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];
    }
}