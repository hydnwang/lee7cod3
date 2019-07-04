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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if (root1 == null || root2 == null) return root1 == root2;
        if (root1.val != root2.val) return false;
        
        boolean res1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean res2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return res1 || res2;
    }
}