/*
              2^10                   n=10
             /    \
           /        \
         /            \
      2^5              2^5           n=5, 2^5 = 2^2 * 2^2 * 2
     /   \            /   \
    /     \          /     \
  2^2     2^2      2^2     2^2       n=2
  / \     / \      / \     / \
 /   \   /   \    /   \   /   \
 2   2   2   2    2   2   2   2      n=1, 2^1 = 1 * 1 * x
/ \ / \ / \ / \  / \ / \ / \ / \
1 1 1 1 1 1 1 1  1 1 1 1 1 1 1 1     n=0


*/

class Solution {
    
    public double myPow(double x, int n) {
        // To handle the case where N=INTEGER_MIN we use a long (64-bit) variable
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        // Solution2: Iterative (Bit manipulation)
        // explanation: https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
        double ans = 1;
        while (N > 0) {
            if ((N & 1) != 0) {
                ans = ans * x;
            }
            x = x * x;
            N >>= 1;
        }
        return ans;
        
        // Solution1: recursive
        return pow(x, N);
    }
    
    public double pow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = pow(x , n/2);
        
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}