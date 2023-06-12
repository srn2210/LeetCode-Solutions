class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<String>();
        int n = nums.length, start = nums[0], end = nums[0];
        var ans = new ArrayList<String>();
        for(int i=1; i<n; i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(start == end) {
                    ans.add(String.valueOf(start));
                    
                }
                else {
                    ans.add(String.valueOf(start) + "->" + String.valueOf(end));
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if(start != end) {
            ans.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
        else {
            ans.add(String.valueOf(start));
        }
        return ans;
    }
}