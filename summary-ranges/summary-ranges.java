class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<String>();
        int n = nums.length, start = nums[0], end = nums[0];
        var ans = new ArrayList<String>();
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(start == end) {
                    ans.add(start + "");
                    
                }
                else {
                    ans.add(start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if(start != end) {
            ans.add(start + "->" + end);
        }
        else {
            ans.add(start + "");
        }
        return ans;
    }
}