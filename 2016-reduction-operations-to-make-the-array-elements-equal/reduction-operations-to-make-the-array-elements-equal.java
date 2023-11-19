class Solution {
    public int reductionOperations(int[] nums) {
        int ans = 0, max = 0;
        for(int num : nums) max = Math.max(max, num);
        int[] buckets = new int[max+1];
        for(int num : nums) buckets[num]++;
        int curr = buckets[max];
        for(int i=buckets.length-2; i>=0; i--) {
            if(buckets[i] > 0) {
                ans += curr;
                curr += buckets[i];
            }
        }
        return ans;
    }
}