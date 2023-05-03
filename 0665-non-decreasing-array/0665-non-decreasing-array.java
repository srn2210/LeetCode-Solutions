class Solution {
    public boolean checkPossibility(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>());
        list.get(0).add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            var lastList = list.get(list.size()-1);
            var lastElement = lastList.get(lastList.size()-1);
            if(nums[i] >= lastElement) lastList.add(nums[i]);
            else {
                var t = new ArrayList<Integer>();
                t.add(nums[i]);
                list.add(t);
            }
        }
        if(list.size() == 1) return true;
        if(list.size() > 2) return false;
        if(list.get(0).size() == 1 || list.get(1).size() == 1) return true;
        if(list.get(0).get(list.get(0).size()-1) <= list.get(1).get(1) || list.get(0).get(list.get(0).size()-2) <= list.get(1).get(0)) return true;
        return false;
    }
}