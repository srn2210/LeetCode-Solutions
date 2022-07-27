class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i=0; i<nums.length; i++) {
            int temp = target - nums[i];
            if(hm.containsKey(temp)) {
                ans[0] = i;
                ans[1] = hm.get(temp);
                return ans;
            }
            hm.put(nums[i], i);
        }
        
        return ans;
    }
}