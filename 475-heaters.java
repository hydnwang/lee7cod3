class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Solution 1: Binary search
        // Sort heater
        Arrays.sort(heaters);
        int dist1, dist2, radius = 0;
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            // usage for java binary search: idx = -(insertion_point) - 1
            // thus insertion_point = -(idx + 1) when idx < 0
            if (idx < 0) idx = -(idx + 1);
            if (idx-1 < 0) { // corner case: left most
                dist1 = Integer.MAX_VALUE;
            } else {
                dist1 = house - heaters[idx-1];
            }
            if (idx >= heaters.length) { // corner case: right most
                dist2 = Integer.MAX_VALUE;
            } else {
                dist2 = heaters[idx] - house;
            }
            radius = Math.max(radius, Math.min(dist1, dist2));
        }
        return radius;
        
        // Solution 2: Two pointers
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int idx = 0, radius = 0;
        for (int house : houses) {
            while (idx < heaters.length-1 
                   && Math.abs(house-heaters[idx]) >= Math.abs(house-heaters[idx+1])
            ) {
                idx++;
            }
            radius = Math.max(radius, Math.abs(heaters[idx]-house));
        }
        return radius;
        
    }
}