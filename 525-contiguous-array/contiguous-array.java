class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0, ans = 0;
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(sum == 0) ans = Math.max(ans, i+1);
            else {
                if(!map.containsKey(sum)) map.put(sum, i);
                if(map.containsKey(sum)) ans = Math.max(ans, i - map.get(sum));
            }
        }
        return ans;
    }
}