/*
refer to solution here:
https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = matrix[row].length - 1;
        int val;
        
        while (row < m && col >= 0) {
            val = matrix[row][col];
            if (val < target) {
                row++;
            } else if (val > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}