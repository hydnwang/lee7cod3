class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        int n = nums.length;
        int i = n - 2;
        
        // step1: find first decending point i when scanning backward
        while (i >= 0 && nums[i+1] <= nums[i]) i--;
        
        // step2: if found, found first number at pos j 
        // that is larger than nums[i], swap them
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // swap i and j
            swap(nums, i, j);
        }
        
        // step3: reverse every item before pos i, 
        // to make the permutation lexicographically smallest
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}