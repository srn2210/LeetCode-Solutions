class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
            if(map.get(nums[i]) == 1) map.remove(nums[i]);
            else map.put(nums[i], map.get(nums[i])-1);
            ans[i] = set.size() - map.size();
        }
        return ans;
    }
}