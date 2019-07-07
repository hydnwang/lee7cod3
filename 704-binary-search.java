class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        // while (left + 1 < right) { // stop at left + 1 - right
        while (left <= right) { // stop at left > right
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // if (nums[left] == target) return left;
        // if (nums[right] == target) return right;
        return -1;
    }
}