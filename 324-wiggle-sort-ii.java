class Solution {
    public void wiggleSort(int[] nums) {
        // Solution1: intuitive with sort and extra storage
        int n = nums.length;
        int mid = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int j = 0;
        for (int i = mid - 1; i >= 0; i--) {
            nums[j] = copy[i];
            j += 2;
        }
        j = 1;
        for (int i = n - 1; i >= mid; i--) {
            nums[j] = copy[i];
            j += 2;
        }
    }
}