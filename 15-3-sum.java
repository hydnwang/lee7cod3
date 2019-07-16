class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length-2; i++) {
            // Cuz nums is sortied and i is the first number
            // of this triplet, so once nums[i] > 0, 
            // no combination can be found
            if (nums[i] > 0) break;
            // Skip duplicate numbers
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length-1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++; // sum too small
                else if (sum > 0) k--; // sum too large
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++; // skip duplicate
                    while (j < k && nums[k] == nums[k-1]) k--; // skip duplicate
                    j++; k--;
                }
            }
        }
        return res;
    }
}