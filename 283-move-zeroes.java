// Refer to:
// https://leetcode.com/problems/move-zeroes/discuss/72012/Python-short-in-place-solution-with-comments.
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != zeroPos) { 
                    // if i and zeroPos not the same
                    // we swap them
                    int temp = nums[i];
                    nums[i] = nums[zeroPos];
                    nums[zeroPos] = temp;
                }
                // after confirm zeroPos being processed
                // we moving zeroPos to next number
                zeroPos++;
            }
        }
        // int i = 0;
        // while (nums[i] > 0) i++;
        // int j = i + 1;
        // while (j < n) {
        //     while (nums[j] == 0) j++;
        //     if (nums[j] > 0) {
        //         int temp = nums[j];
        //         nums[j] = nums[i];
        //         nums[i] = temp;
        //     }
        //     i = j;
        //     j = i+1;
        // }
    }
}