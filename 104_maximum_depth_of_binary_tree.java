/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int max_depth = 0;
    
    public int maxDepth(TreeNode root) {
        // Solution1: Divide and Conquer
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        
        // Solution2: Recursive DFS
        recursion(root, 0);
        return max_depth;
        
        // Solution3: Iteration
        // BFS + stack
    }
    
    // DFS helper function
    void recursion(TreeNode root, int curDepth) {
        if (root == null) return;
        curDepth++;
        if (curDepth > max_depth) {
            max_depth = curDepth;
        }
        recursion(root.left, curDepth);
        recursion(root.right, curDepth);
    }
}