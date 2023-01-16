class Solution {
    long sum(int n) {
        if(n == 1) return 0;
        else return (n * (n - 1)) / 2;
    }
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int hi = 0;
        int lo = 0;
        long curr = 0;
        long ans = 0;
        while(lo < nums.length && hi <= nums.length) {
            if(curr < k && hi < nums.length) {
                map.put(nums[hi], map.getOrDefault(nums[hi], 0) + 1);
                if(map.get(nums[hi]) >= 2) {
                    curr += (sum(map.get(nums[hi])) - sum(map.get(nums[hi])-1));
                }
                hi++;
            }
            else {
                if(curr >= k) {
                    ans += nums.length - hi + 1;
                }
                if(map.get(nums[lo]) >= 2) {
                    curr = curr - sum(map.get(nums[lo])) + sum(map.get(nums[lo])-1);
                }
                map.put(nums[lo], map.get(nums[lo])-1);
                lo++;
            }
        }
        return ans;
    }
}