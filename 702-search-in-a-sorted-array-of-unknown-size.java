class Solution {
    public int search(ArrayReader reader, int target) {
        
        int left = 0, right = 1;
        while (true) {
            // System.out.println("reader get: " + reader.get(left));
            if (reader.get(right) > target) {
                break;
            }
            left = right;
            right <<= 1;
        }
        // System.out.println("target is between: " + left + ", " + right);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // System.out.println("left get: " + reader.get(left));
        // System.out.println("right get: " + reader.get(right));
        return -1;
    }
}