class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        var ans = new ArrayList<Boolean>();
        var list = new ArrayList<Integer>(nums.length);

        for(int i=0; i<l.length; i++) {
            for(int j=l[i]; j<=r[i]; j++) {
                list.add(nums[j]);
            }
            Collections.sort(list);
            int diff = list.get(1) - list.get(0);
            boolean flag = true;
            for(int j=2; j<list.size(); j++) {
                if(list.get(j) - list.get(j-1) != diff) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
            list.clear();
        }
        return ans;
    }
}