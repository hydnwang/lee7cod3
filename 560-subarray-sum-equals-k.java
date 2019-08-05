class Solution {
    public int subarraySum(int[] nums, int k) {
        // Solution1: Intuitive way with Two pointers
        int ans = 0;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;

        // Solution2: Derived from solution1 with hashmap
        int n = nums.length;
        int ans = 0, sum = 0;

        // map<sum, count>
        Map<Integer, Integer> map = new HashMap();
        // when sum == k, found one solution for the first time
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}