class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        
        // solution2: traverse from left to right (only update when needed, faster)
        Arrays.fill(result, -1);
        for (int i = 0; i < 2*n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                result[stack.pop()] = nums[idx];
            }
            if (i < n) stack.push(idx);
        }
        
        // solution1: traverse from right to left
        for (int i = 2*n-1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[idx]) {
                stack.pop();
            }
            // update result
            if (stack.isEmpty()) result[idx] = -1;
            else result[idx] = nums[stack.peek()];
            // keep pushing 
            stack.push(idx);
        }
        
        
        return result;
    }
}