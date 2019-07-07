class Solution {
    public boolean checkPerfectNumber(int num) {
        int res = 0;
        // don't consider numbers less or equal 0
        if (num <= 0) {
            return false;
        }

        // for (int i = 1; i <= Math.sqrt(num); i++) { // to speed up, don't use lib
        for (int i = 1; i * i <= num; i++) { // divisors exist in pairs, so consider range in sqrt(i)
            if (num % i == 0) {
                res += i;
                // if (num/i != i) { // to speed up, don't use division
                if (i * i != num) {
                    res += num / i;
                }
            }
        }
        // don't consider the num itself
        return res - num == num;
    }
}