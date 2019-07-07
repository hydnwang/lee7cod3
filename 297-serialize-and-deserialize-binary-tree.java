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
reference solution: 
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution/77363
*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root, new StringBuilder()).toString();
    }
    
    public StringBuilder dfs(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return str;
        }
        // concatenate root.val
        str.append(root.val + ",");
        dfs(root.left, str);
        dfs(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
        return constructTree(q);
    }
    
    public TreeNode constructTree(Queue<String> q) {
        String v = q.poll();
        if ("null".equals(v)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(v));
        node.left = constructTree(q);
        node.right = constructTree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));