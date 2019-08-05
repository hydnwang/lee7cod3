class Solution {
    public int longestMountain(int[] A) {
        // Reference for solution 1&2:
        // https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C++JavaPython-1-pass-and-O(1)-space
        
        // Solution1: using concept of prefix sum with 2 passes, 
        // one pass going forward from left to right, one going backward
        int n = A.length;
        if (n < 3) return 0;
        int ans = 0;
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = n-2; i >= 0; i--) {
            if (A[i] > A[i+1]) {
                down[i] = down[i+1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && A[i] > A[i-1]) {
                up[i] = up[i-1] + 1;
            }
            if (up[i] > 0 && down[i] > 0) {
                ans = Math.max(ans, up[i]+down[i]+1);
            }
        }
        return ans;
        
        // Solution2: using concept of prefix sum with 1 pass
        int n = A.length;
        if (n < 3) return 0;
        int up = 0, down = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            if ((down > 0 && A[i] > A[i-1]) || A[i] == A[i-1]) {
                up = 0;
                down = 0;
            }
            if (A[i] > A[i-1]) up++;
            if (A[i] < A[i-1]) down++;
            if (up > 0 && down > 0) ans = Math.max(ans, up+down+1);
        }
        return ans;
        
        // Solution3: Intuitive solution with Two pointers
        // https://leetcode.com/problems/longest-mountain-in-array/discuss/165667/1-pass-Java-Two-Point-Solution
        int n = A.length;
        if (n < 3) return 0;
        int ans = 0, left = 0, right;
        // left < n-2 so we can have a complete mountain 
        // with length 3 (n-3~n-1) as requested by the problem
        while (left < n-2) { 
            // find left boundary
            while (left < n-1 && A[left+1] <= A[left]) left++;
            
            // left boundary found
            right = left + 1;
            
            // find peak
            while (right < n-1 && A[right] < A[right+1]) right++;
            
            // peak found, find right bondary
            while (right < n-1 && A[right] > A[right+1]) {
                right++;
                ans = Math.max(ans, right-left+1);
            }
            
            // reset boundary for next range if any
            left = right;
        }
        return ans;
    }
}