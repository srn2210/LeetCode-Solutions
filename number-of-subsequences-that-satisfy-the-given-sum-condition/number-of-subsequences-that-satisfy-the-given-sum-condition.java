class Solution {
    int modPow(int base, int exp, int mod, int[] cache) {
        if(exp == 0) return 1;
        if(cache[exp] != -1) return cache[exp];
        long res = 1;
        if(exp % 2 != 0) res *= base;
        int t = modPow(base, exp/2, mod, cache) % mod;
        res = (res%mod) * t * t;
        return cache[exp] = (int)(res % mod);
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int)1e9+7, ans = 0;
        int[] cache = new int[nums.length+1];
        Arrays.fill(cache, -1);
        int left = 0, right = nums.length-1;
        while(left <= right) {
            if(nums[left] + nums[right] > target) right--;
            else {
                ans += modPow(2, right-left, mod, cache);
                ans %= mod;
                left++;
            }
        }
        return ans;
    }
}