class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n-1];
        int sum, left, right;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            left = i + 1;
            right = n - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    res = sum;
                    break;
                }
                if (Math.abs(sum-target) < Math.abs(res-target)) res = sum;
                if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
}