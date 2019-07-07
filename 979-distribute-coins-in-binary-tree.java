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
Refer to: 
1. https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC%2B%2BPython-Recursive-Solution
2. https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC++Python-Recursive-Solution/224633
3. 花花醬
*/
class Solution {
    int ans = 0;
    
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }
    public int distribute(TreeNode root) {
        if (root == null) return 0;
        
        int left = distribute(root.left);
        int right = distribute(root.right);
        
        // flow of left + flow of rigth
        ans += Math.abs(left) + Math.abs(right);

        // return to previous level with flow of root added
        int rootBalance = root.val - 1;
        return left + right + rootBalance;
    }
}