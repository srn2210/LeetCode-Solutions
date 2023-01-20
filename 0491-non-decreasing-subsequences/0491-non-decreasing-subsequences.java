class Solution {
    void backtrack(Set<List<Integer>> ans, List<Integer> list, int idx, int[] nums) {
        if(list.size() >= 2) {
            ans.add(new ArrayList<>(list));
        }
        for(int i=idx; i<nums.length; i++) {
            if(list.size() == 0 || list.get(list.size()-1) <= nums[i]) {
                list.add(nums[i]);
                backtrack(ans, list, i+1, nums);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return new ArrayList<>(ans);
    }
}