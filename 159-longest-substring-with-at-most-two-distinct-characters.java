class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;
        
        int left = 0, right = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap();
        // Set<Character> set = new HashSet();
        
        // for (int i = 0; i < n; i++) {
        while (right < n) {
            // set.add(s.charAt(i));
            if (map.size() <= 2) {
                map.put(s.charAt(right), right);
                right++;
            } 
            if (map.size() > 2) {
                // find the character with smallest index to remove
                // int idx = Collections.min(map.values());
                int idx = n;
                for (int i : map.values()) {
                    idx = Math.min(idx, i);
                }
                map.remove(s.charAt(idx));
                // left most will start from right of idx: idx+1
                left = idx + 1;
            }
            res = Math.max(res, right-left);
        }
        return res;
    }
}