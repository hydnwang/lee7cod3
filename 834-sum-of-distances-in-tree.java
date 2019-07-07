/* 
Reference solution:
1. https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
2. Michelangelo: LeetCode 834. Sum of Distances in Tree (https://www.youtube.com/watch?v=gi2maECPOB0)
*/

class Solution {
    
    int[] distanceSum, nodeCount;
    ArrayList<HashSet<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        
        // distance sum of all chidren of node i
        distanceSum = new int[N];
        
        // number of nodes in the subtree of node i
        nodeCount = new int[N];
        
        // initialize tree
        tree = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        // dfs 1st time: update nodeCount of each node
        updateNodeCount(0, -1);
        
        // dfs 2nd time: compute distanceSum based on 
        // nodeCount and distanceSum[0]
        updateDistanceSum(0, -1);
        
        return distanceSum;
    }
    
    public void updateNodeCount(int curr, int prev) {
        for (int i : tree.get(curr)) {
            if (i == prev) continue;
            updateNodeCount(i, curr);
            nodeCount[curr] += nodeCount[i];
            // in order to get distanceSum[0], so we can update distanceSum[i]
            distanceSum[curr] += distanceSum[i] + nodeCount[i];
        }
        nodeCount[curr] += 1;
    }
    
    public void updateDistanceSum(int curr, int prev) {
        for (int i : tree.get(curr)) {
            if (i == prev) continue;
            // update distanceSum[i] based on distanceSum[0] and nodeCount[i]
            // distanceSum[i] = distanceSum[parent] + nodeCount[parent] - nodeCount[i]
            //                = distanceSum[parent] + (N - nodeCount[i]) - nodeCount[i]
            distanceSum[i] = distanceSum[curr] + (nodeCount.length - nodeCount[i]) - nodeCount[i];
            updateDistanceSum(i, curr);
        }
    }
}