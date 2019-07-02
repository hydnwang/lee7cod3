/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution ref: https://www.youtube.com/watch?v=LfKRZ_qCmYQ
// Solution ref:
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
/* 
Time: O(n)
Space: O(1)
*/
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // post order
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}