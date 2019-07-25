class Solution {
    public int rob(int[] nums) {
        // every time we can choose whether to pick
        // [prevMax, currMax, (current)nums[i], ...]
        // max will be (prevMax + nums[i]) or currMax
        int prevMax = 0;
        int currMax = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}