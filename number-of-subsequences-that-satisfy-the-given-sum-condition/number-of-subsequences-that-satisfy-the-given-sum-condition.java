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
    public int numSubseq(int[] nums, int target) {
       Arrays.sort(nums);
       //int mod = (int)1e9+7;
       BigInteger mod = new BigInteger("1000000007");
       BigInteger t = new BigInteger("2");
       int ans = 0;
       for(int i=0; i<nums.length; i++) {
           int rem = target - nums[i];
           if(rem < nums[i]) continue;
           int idx = binarySearch(nums, rem);
           //System.out.println(i + " - " + idx + " - " + nums[i] + " - " + nums[idx]);
           //ans %= mod;
           //ans += (long)(Math.pow(2, (idx-i)%63) % mod);
           ans %= (int)1e9+7;
           ans += t.modPow(new BigInteger(String.valueOf(idx-i)), mod).intValue();
           ans %= (int)1e9+7;
       }
       return ans;
    }
}