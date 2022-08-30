class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new LinkedHashSet<>(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, Set<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(List.copyOf(tempList));
        } 
        else{
            for(int i = 0; i < nums.length; i++){ 
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(nums[i]);
            }
        }
    }
}