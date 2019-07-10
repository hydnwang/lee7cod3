class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Solution1: Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
        
        // Solution2: QuickSelect
        k = nums.length - k; // find largest k == smallest n - k
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    // helper for quick select
    public int partition(int[] A, int start, int end) {
        int pivot = A[end]; // choose rightmost item as pivot
        int flag = start;
        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                swap(A, i, flag);
                flag++;
            }
        }
        // move pivot value to the position the last time you swapped
        swap(A, flag, end);
        return flag;
    }
    
    // helper for quick select
    public int quickSelect(int[] nums, int left, int right, int k) {
        // Method1: recursive
        if (left == right) return nums[left];
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            return nums[pivot];
        }
        if (pivot > k) {
            return quickSelect(nums, left, pivot-1, k);
        } else {
            return quickSelect(nums, pivot+1, right, k);
        }
        
        // Method2: iterative
        // int pivot = right;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k) {
                return nums[pivot];
            }
            if (pivot > k) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}