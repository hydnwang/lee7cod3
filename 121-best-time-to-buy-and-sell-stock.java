class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 0; i < n; i++) {
            // check if current price is the lowest
            minPrice = Math.min(prices[i], minPrice);
            // or if we can maximize profit selling with current price
            maxProfit = Math.max(prices[i]-minPrice, maxProfit);
        }
        return maxProfit;
    }
}