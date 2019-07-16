/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        int peak = 0;
        int mid = 0;
        // find peak
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) > mountainArr.get(mid+1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        peak = left;
        
        // find the half with increasing order
        left = 0;
        right = peak;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // find the half with decreasing order
        left = peak;
        right = n - 1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) == target) return mid;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}