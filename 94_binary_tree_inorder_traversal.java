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
    List<Integer> rlist = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1. iterative
        // Time: O(n), Space: O(n)
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ilist = new ArrayList<>();
        
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ilist.add(root.val);
            root = root.right;
        }
        return ilist;

        // 2. recursive
        // Time: O(n), Space: O(n)
        traverse(root);
        return rlist;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        rlist.add(root.val);
        traverse(root.right);
    }
}