class Solution {
    public void helper(List<List<Integer>> list, Set<Integer> set, int[] nums) {
        if(set.size() == nums.length) {
            list.add(new ArrayList(set));
            return;
        }
        else {
            for(int num:nums) {
                if(set.add(num)) {
                    helper(list, set, nums);
                    set.remove(num);
                }
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        
        helper(list, new LinkedHashSet(), nums);
        
        return list;
    }
}