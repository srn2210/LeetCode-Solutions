class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new LinkedHashSet<>(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, Set<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } 
        else{
            for(int i:nums){ 
                if(tempList.contains(i)) 
                    continue;
                tempList.add(i);
                backtrack(list, tempList, nums);
                tempList.remove(i);
            }
        }
    }
}