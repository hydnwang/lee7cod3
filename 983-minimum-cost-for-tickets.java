class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        // the last day is the LAST day of days[]
        int lastDay = days[n - 1];
        // dp stores the minimum cost from day "1" (not 0) up to day n
        int[] dp = new int[lastDay + 1];
        // Record what days to travel
        boolean[] isTraveling = new boolean[lastDay + 1];
        for (int day : days)
            isTraveling[day] = true;

        int day1, day7, day30;

        for (int i = 1; i <= lastDay; i++) {
            if (!isTraveling[i]) {
                // if not traveling on that day
                // the cost dp[i] will remain the same
                // as previous day dp[i-1]
                dp[i] = dp[i - 1];
                continue;
            }

            // 1-day pass cost plus the cost of previous day
            day1 = dp[i - 1] + costs[0];

            // 7-day pass cost plus the cost of the day 7 days ago
            if (i > 7) {
                day7 = Math.min(day1, dp[i - 7] + costs[1]);
            } else {
                day7 = Math.min(day1, dp[0] + costs[1]);
            }
            // 30-day pass cost plus the cost of the day 30 days ago
            if (i > 30) {
                day30 = Math.min(day7, dp[i - 30] + costs[2]);
            } else {
                day30 = Math.min(day7, dp[0] + costs[2]);
            }

            // the cost of day i is min(day1, day7, day30)
            dp[i] = day30;
        }
        return dp[lastDay];
    }
}