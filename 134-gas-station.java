class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int curTank = 0;
        int startingPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasRemain = gas[i] - cost[i];
            totalTank += gasRemain;
            curTank += gasRemain;
            if (curTank < 0) {
                curTank = 0;
                startingPoint = i + 1;
            }
        }
        
        if (totalTank >= 0) return startingPoint;
        return -1;
    }
}