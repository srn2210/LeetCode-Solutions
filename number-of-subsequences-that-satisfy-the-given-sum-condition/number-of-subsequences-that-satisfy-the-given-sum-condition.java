class Solution {
    int binarySearch(int[] nums, int rem) {
        int lo = 0, hi = nums.length-1;
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= rem) {
                ans = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return ans;
    }
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
       int mod = (int)1e9+7;
       int ans = 0;
       int[] cache = new int[nums.length+1];
       Arrays.fill(cache, -1);
       for(int i=0; i<nums.length; i++) {
           int rem = target - nums[i];
           if(rem < nums[i]) break;
           int idx = binarySearch(nums, rem);
           ans += modPow(2, idx-i, mod, cache);
           ans %= mod;
       }
       return ans;
    }
}