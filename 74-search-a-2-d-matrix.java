class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        int mid, val;
        
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            val = matrix[mid/col][mid%col];
            if (val == target) return true;
            if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}