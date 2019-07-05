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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(root, 0, 0));
        
        int curDepth = 0;
        int left_most_pos = 0;
        int max_width = 0;
        
        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            if (loc.node != null) {
                if (loc.node.left != null) {
                    queue.add(new Location(loc.node.left, loc.x*2, loc.y+1));
                }
                if (loc.node.right != null) {
                    queue.add(new Location(loc.node.right, loc.x*2+1, loc.y+1));
                }
                if (curDepth != loc.y) {
                    curDepth = loc.y;
                    left_most_pos = loc.x;
                }
                max_width = Math.max(max_width, loc.x-left_most_pos+1);
            }
        }
        return max_width;
    }
    class Location {
        int x, y;
        TreeNode node;
        Location (TreeNode node, int x, int y) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
}