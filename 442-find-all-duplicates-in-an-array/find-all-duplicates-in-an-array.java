class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var ans = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            int ind = nums[i] < 0 ? nums[i] * -1 : nums[i];
            ind--;
            if(nums[ind] < 0) ans.add(ind+1);
            else nums[ind] = -1 * nums[ind];
        }
        return ans;
    }
}