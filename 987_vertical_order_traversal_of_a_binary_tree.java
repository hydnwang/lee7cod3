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
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231425/Java-Solution-using-Only-PriorityQueue/233523
*/
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // 1. create a priority queue and 
        // customize comparator to sort by order:x then y then value
        Comparator comparator = new Comparator<Location>() {
            public int compare(Location l1, Location l2) {
                if (l1.x != l2.x) return l1.x-l2.x;
                if (l1.y != l2.y) return l1.y-l2.y;
                return l1.val - l2.val;
            }
        };
        Queue<Location> queue = new PriorityQueue<Location>(comparator);
        
        // 2. dfs traverse the tree and store the coordinates of nodes
        dfs(root, 0, 0, queue);
        
        // 3. cast out the nodes by order and copy them to 
        // a new list separate by coordinate x.
        int prev_x = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Location node = queue.poll();
            if (node.x > prev_x) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                result.add(list);
            } else {
                List<Integer> list = result.get(result.size()-1);
                list.add(node.val);
            }
            prev_x = node.x;
        }
        return result; 
    }
    
    public void dfs(TreeNode root, int x, int y, Queue<Location> queue) {
        if (root == null) return;
        queue.add(new Location(x, y, root.val));
        dfs(root.left, x-1, y+1, queue);
        dfs(root.right, x+1, y+1, queue);
    }
    
    class Location {
        int x, y, val;
        Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.val = value;
        }
    }
    
}