class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        var map = new HashMap<Integer, Integer>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);
        for(int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum-goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}