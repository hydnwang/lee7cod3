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
    public int countNodes(TreeNode root) {
        // Solution2: 
        // refer to main solution in: https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
        // refer to: https://www.jiuzhang.com/solution/count-complete-tree-nodes/#tag-highlight
        int result = 0;
        int h = height(root);
        
        while (root != null) {
            if (height(root.right) == h-1) {
                // the last node on the last tree row is in the right subtree 
                // and the left subtree is a full tree of height h-1. 
                // So we take the 2^h-1 nodes of the left subtree plus the 1 root node 
                // plus recursively the number of nodes in the right subtree.
                result += 1 << h;
                root = root.right;
            } else {
                // the last node on the last tree row is in the left subtree 
                // and the right subtree is a full tree of height h-2. 
                // So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node 
                // plus recursively the number of nodes in the left subtree.
                result += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return result;
        
        // // Solution1: Binary Search
        // 1. if tree doesn't exist
        if (root == null) return 0;
        // 2. if tree has only 1 level
        if (root.left == null) return 1;
        // 3. Compute depth of the tree
        int depth = findTreeDepth(root);
        // if (depth == 0) return 1;
        // 4. Binary search from the middle point of the last level
        int left = 0;
        int right = (int)Math.pow(2, depth) - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // the mid point is present, check the right half of the mid
            if (exists(mid, depth, root)) left = mid + 1;
            // else check the left half of the mid
            else right = mid - 1;
        }
        // 5. confirm the boundary
        if (exists(left, depth, root)) left++;
        // 6. Add up number of nodes from previous levels and the last level
        int result = (int)Math.pow(2, depth) - 1 + left;
        return result;
    }
    
    // Solution2: helper function
    public int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }
    
    // Solution1: helper function
    public boolean exists(int target, int depth, TreeNode root) {
        int left = 0;
        int right = (int)Math.pow(2, depth) - 1;
        int mid;
        for (int i = 0; i < depth; i++) {
            mid = left + (right - left) / 2;
            if (target <= mid) {
                right = mid;
                root = root.left;
            } else {
                left = mid + 1;
                root = root.right;
            }
        }
        return root != null;
    }
    // Solution1: helper function
    public int findTreeDepth(TreeNode root) {
        int d = 0;
        while (root.left != null) {
            root = root.left;
            d++;
        }
        return d;
    }
}