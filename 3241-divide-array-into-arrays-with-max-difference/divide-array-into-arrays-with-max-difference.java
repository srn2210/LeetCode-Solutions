class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=3) {
            if(nums[i] + k >= nums[i+2]) ans.add(new int[]{nums[i], nums[i+1], nums[i+2]});
            else return new int[0][0];
        }
        int[][] res = new int[ans.size()][];
        for(int i=0; i<ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
}