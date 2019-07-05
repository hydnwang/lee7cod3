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
    // TreeNode prev;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key == root.val) {
            // case1: node is leaf
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case2: node has right child
            // find successor
            else if (root.right != null) {
                TreeNode successor = successor(root);
                // replave root.val by successor.val
                root.val = successor.val;
                // find successor and delete it
                root.right = deleteNode(root.right, root.val);
            }
            // case3: node has left child
            // find predecessor
            else if (root.left != null) {
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root;
    }
    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root;
    }
}