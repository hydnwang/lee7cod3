// https://leetcode.com/problems/push-dominoes/discuss/132332/C++JavaPython-Two-Pointers
class Solution {
    public String pushDominoes(String dominoes) {
        // we need 1 additional L as left boundary
        // and 1 additional R as right boudary
        // to align with our algorithm to whole string
        String d = 'L' + dominoes + 'R';
        int n = d.length();
        int left = 0;
        StringBuilder res = new StringBuilder();
        for (int right = 1; right < n; right++) {
            if (d.charAt(right) == '.') continue;
            int mid = right - left - 1;
            if (left > 0) res.append(d.charAt(left));
            if (d.charAt(left) == d.charAt(right)) { // LL or RR
                for (int k = 0; k < mid; k++) {
                    res.append(d.charAt(left));
                }
            } else if (d.charAt(left) == 'L' && d.charAt(right) == 'R') {
                for (int k = 0; k < mid; k++) {
                    res.append('.');
                }
            } else { // R..L
                for (int k = 0; k < mid; k++) {
                    if (left+k+1 == right-k-1) {
                        res.append('.');
                    } else {
                        if (left+k+1 < right-k-1) res.append('R');
                        else res.append('L');
                    }
                }
            }
            left = right;
        }
        return String.valueOf(res);
    }
}