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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        List<Integer> curPath = new ArrayList<Integer>();
        dfs(root, sum, curPath, path);
        return path;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> curPath, List<List<Integer>> path) {
        if (root == null) {
            // if add curPath here, left and right will both add it,
            // so result will be added totally twice
            // if (targetSum == 0) {
            //     path.add(new ArrayList(curPath));
            // }
            return;
        }
        curPath.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            path.add(new ArrayList(curPath));
        }
        dfs(root.left, targetSum-root.val, curPath, path);
        dfs(root.right, targetSum-root.val, curPath, path);
        curPath.remove(curPath.size()-1);
    }
}