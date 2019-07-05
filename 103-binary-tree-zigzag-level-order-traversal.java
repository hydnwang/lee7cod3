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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        int direction = 1;

        // User Queue and Double-end List
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (direction < 0) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
            direction *= -1;
        }

        // User 2 Stacks
        // Stack<TreeNode> stack1 = new Stack<>();
        // Stack<TreeNode> stack2 = new Stack<>();
        // stack1.push(root);
        // while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // List<Integer> level = new ArrayList<>();
            // if (direction > 0) {
                // while (!stack1.isEmpty()) {
                //     TreeNode node = stack1.pop();
                //     level.add(node.val);
                //     if (node.left != null) stack2.push(node.left);
                //     if (node.right != null) stack2.push(node.right);
                // }
            // } else {
                // while (!stack2.isEmpty()) {
                //     TreeNode node = stack2.pop();
                //     level.add(node.val);
                //     if (node.right != null) stack1.push(node.right);
                //     if (node.left != null) stack1.push(node.left);
                // }
            // }
            // result.add(level);
            // direction *= -1;
        // }
        return result;
    }
}