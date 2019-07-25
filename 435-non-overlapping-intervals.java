class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort with ends of intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int cnt = 0;
        int prev = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // no overlap, update latest end of interval
                end = intervals[i][1];
            } else {
                // overlap occurred, ignore current interval
                // keep the end of previous interval
                cnt++;
            }
        }
        return cnt;
    }
}