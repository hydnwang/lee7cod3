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
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }
    
    public int traverse(TreeNode root, int curSum) {
        if (root == null) return 0;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        }
        return traverse(root.left, curSum) + traverse(root.right, curSum);
    }
}