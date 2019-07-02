/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 
Time: O(n) 
Space: O(n)
*/
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        traverse(root1, l1);
        traverse(root2, l2);
        for(int i = 0; i < l1.size(); i++) {
            if(l1.get(i) != l2.get(i)) return false;
        }
        return true;
        // return l1.equals(l2); // slower than for loop
    }
    
    public void traverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        traverse(root.left, list);
        traverse(root.right, list);
    }
}