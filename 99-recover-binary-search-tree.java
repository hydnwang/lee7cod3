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
    TreeNode rprev = null, rx = null, ry = null;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        
        // Solution2: Recursive
        findOutOfOrderNodes(root);
        // swap
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
        
        // Solution1: Iterative
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, x = null, y = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (prev != null && prev.val > root.val) {
                // System.out.println("out of order detected: " + prev.val + ", " + root.val);
                y = root;
                if (x == null) x = prev;
            }
            // System.out.println("node: " + root.val);
            prev = root;
            root = root.right;
        }
        // // swap
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    
    public void findOutOfOrderNodes(TreeNode root) {
        if (root == null) return;
        findOutOfOrderNodes(root.left);
        if (rprev != null && rprev.val > root.val) {
            ry = root;
            if (rx == null) rx = rprev;
        }
        rprev = root;
        findOutOfOrderNodes(root.right);
    }
}