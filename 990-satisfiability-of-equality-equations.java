class Solution {
    public boolean equationsPossible(String[] equations) {
        // Union find
        // step1: initilize parent table
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;
        
        // step2: union
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(parent, x, y);
            }
        }
        
        // step3: check discrepancies
        for (String eq : equations) {
            int x = eq.charAt(0) - 'a';
            int y = eq.charAt(3) - 'a';
            if (eq.charAt(1) == '!' && find(parent, x) == find(parent, y)) {
                return false;
            }
        }
        return true;
    }
    
    // helper find
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
        }
        return parent[x];
    }
    // helper union
    private void union(int[] parent, int x, int y) {
        parent[find(parent, y)] = find(parent, x);
    }
}