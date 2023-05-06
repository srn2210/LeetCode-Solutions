import java.math.*;
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
    int modPow(int base, int exp, int mod) {
        if(exp == 0) return 1;
        long res = 1;
        if(exp % 2 != 0) res *= base;
        int t = modPow(base, exp/2, mod) % mod;
        res = (res%mod) * t * t;
        return (int)(res % mod);
    }
    public int numSubseq(int[] nums, int target) {
       Arrays.sort(nums);
       int mod = (int)1e9+7;
       int ans = 0;
       for(int i=0; i<nums.length; i++) {
           int rem = target - nums[i];
           if(rem < nums[i]) continue;
           int idx = binarySearch(nums, rem);
           ans %= (int)1e9+7;
           //ans += t.modPow(new BigInteger(String.valueOf(idx-i)), mod).intValue();
           ans += modPow(2, idx-i, mod);
           //System.out.println(modPow(2, 31, mod));
           ans %= (int)1e9+7;
       }
       return ans;
    }
}