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
Reference solution: 
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C++JavaPython-One-Pass-Real-O(N)/174387
*/
class Solution {
    int[] pre, post;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {    
        this.pre = pre;
        this.post = post;
        for(int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return traverse(0, pre.length-1, 0, post.length-1);
    }
    
    public TreeNode traverse(int pre_start, int pre_end, int post_start, int post_end) {
        if (pre_start > pre_end || post_start > post_end) return null;
        
        TreeNode root = new TreeNode(pre[pre_start]);
        
        if (pre_start+1 <= pre_end) {
            int left_idx = map.get(pre[pre_start+1]) - post_start;
            root.left = traverse(pre_start+1, pre_start+1+left_idx, post_start, post_start+left_idx);
            root.right = traverse(pre_start+1+left_idx+1, pre_end, post_start+left_idx+1, post_end-1);
        }
        return root;
    }
}