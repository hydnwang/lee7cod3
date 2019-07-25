class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // sort by starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue();
        // int room = 0;
        for (int[] interval : intervals) {
            // if some rooms are already occupied, 
            // but current meeting start later than 
            // the one which ends earlies, pop the that room
            if (pq.size() > 0 && interval[0] >= pq.peek()) {
                pq.poll();
            } 
            // else {
            //     room++;
            // }
            
            // add meeting in queue wait to check 
            // if it blocks other meetings
            // if it doesn't, it will be popped later
            pq.offer(interval[1]);
        }
        
        // return room;
        return pq.size();
    }
}