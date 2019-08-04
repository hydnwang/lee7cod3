// Greedy + Two Pointer
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int lighter = 0;
        int heavier = n - 1;
        int boat = 0;
        while (lighter <= heavier) {
            boat++;
            if (people[lighter] + people[heavier] <= limit) lighter++;
            heavier--;
        }
        return boat;
    }
}