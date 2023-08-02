class Solution {
    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    void backtrack(List<List<Integer>> ans, int[] nums, int end, List<Integer> curr) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        else {
            for(int i=0; i<=end; i++) {
                curr.add(nums[i]);
                swap(nums, i, end);
                backtrack(ans, nums, end-1, curr);
                curr.remove(curr.size()-1);
                swap(nums, i, end);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        backtrack(ans, nums, nums.length-1, new ArrayList<>());
        return ans;
    }
}