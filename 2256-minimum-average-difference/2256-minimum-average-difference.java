class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for(int i:nums) sum += i;
        long curr = 0;
        long ans = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            curr += nums[i];
            long a = (curr/(i+1));
            long b = 0;
            if(i != nums.length-1) {
                b = (sum-curr)/(nums.length-i-1);
            }
            long temp = Math.abs(a - b);
            if(temp < ans) {
                ans = temp;
                res = i;
            }
        }
        return res;
    }
}