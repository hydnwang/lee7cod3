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
    TreeNode rhead = null;
    TreeNode rprev = null;
    
    public TreeNode increasingBST(TreeNode root) {
        // Solution1: recursive 
        // Time: O(n), Space: O(1)
        if (root == null) return null;
        increasingBST(root.left);
        if (rhead == null) {
            rhead = root;
        }
        root.left = null;
        if (rprev != null) {
            rprev.right = root;
        }
        rprev = root;
        increasingBST(root.right);
        return rhead;
        
        // Solution2: iterative
        // Time: O(n), Space: O(n) worst-case
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode head = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (head == null) {
                head = root;
            }
            // cut off link from root to prev 
            // only prev to point to root, else dead loop
            // => also prev stores root.left from previous iteration
            // => if previous root is left child
            root.left = null; 
            if (prev != null) {
                prev.right = root;
            }
            prev = root;
            root = root.right;
        }        
        return head;
    }
}