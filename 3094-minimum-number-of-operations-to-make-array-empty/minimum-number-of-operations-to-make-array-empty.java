class Solution {
    public int minOperations(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int ans = 0;
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for(int value : map.values()) {
            if(value == 1) return -1;
            else {
                if(value % 3 == 0) ans += value / 3;
                else ans += value / 3 + 1;
            }
        }
        return ans;
    }
}