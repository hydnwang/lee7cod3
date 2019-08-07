// Refer to
// https://leetcode.com/problems/3sum-with-multiplicity/discuss/181128/10-lines-Super-Super-Easy-Java-Solution
class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap();
        int n = A.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target-A[i])) {
                cnt = (cnt + map.get(target-A[i])) % 1000000007;
            }
            for (int j = 0; j < i; j++) {
                map.put(A[i]+A[j], map.getOrDefault(A[i]+A[j], 0) + 1);
            }
        }
        return cnt;
    }
}