class Solution {
    void reverse(int num, Map<Integer, Integer> map) {
        int ans = 0;
        int cpy = num;

        while(num > 0) {
            ans = (ans * 10) + num % 10;
            num /= 10;
        }

        int diff = cpy - ans;
        map.put(diff, map.getOrDefault(diff, 0) + 1);
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length, mod = (int)1e9+7;
        long ans = 0;
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
            reverse(nums[i], map);
        }

        for(var entry : map.entrySet()) {
            int numDiff = entry.getValue();
            if(numDiff <= 1) continue;

            ans += ((long) numDiff * (numDiff-1)) / 2;
            ans %= mod;
        }

        return (int)ans;
    }
}