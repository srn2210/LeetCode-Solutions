class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int ans = 1;
        int curr = 1;
        int prev = Integer.MIN_VALUE;
        
        for(int i:nums){
            if(prev == i-1){
                curr++;
                prev = i;
            }
            else if(prev == i){
                prev = i;
                continue;
            }
            else if (prev < i-1){
                ans = Math.max(ans, curr);
                curr = 1;
                prev = i;
            }
        }
        ans = Math.max(ans, curr);
        
        return ans;
    }
}