// Refer to
// https://leetcode.com/problems/longest-turbulent-subarray/discuss/222146/PythonJavaC%2B%2B-O(n)-time-O(1)-space-Simple-and-Clean-solution
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        int len = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 2 && ((A[i-2] > A[i-1] && A[i-1] < A[i]) 
                       ||  (A[i-2] < A[i-1] && A[i-1] > A[i]))) {
                len++;
            } else if (i >= 1 && A[i-1] != A[i]) {
                len = 2;
            } else {
                len = 1;
            }
            ans = Math.max(len, ans);
        }
        return ans;
    }
}