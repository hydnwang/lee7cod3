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
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        
        if (pstart > pend || istart > iend) return null;
        
        int target = preorder[pstart];
        int pos = map.get(target);
        // int pos = 0;
        // for(int i = istart; i <= iend; i++) {
        //     if (inorder[i] == target) {
        //         pos = i;
        //         break;
        //     }
        // }
        
        int left_len = pos - istart;
        
        TreeNode node = new TreeNode(preorder[pstart]);
        node.left = build(preorder, inorder, pstart+1, pstart+left_len, istart, pos-1);
        node.right = build(preorder, inorder, pstart+left_len+1, pend, pos+1, iend);
        return node;
    }
}