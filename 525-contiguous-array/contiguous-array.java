class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0, ans = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) ans = Math.max(ans, i - map.get(sum));
            else map.put(sum, i);
        }
        return ans;
    }
}