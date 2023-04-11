class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var tmap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(int i=0; i<k; i++) tmap.put(nums[i], tmap.getOrDefault(nums[i], 0) + 1);
        int[] ans = new int[nums.length - k + 1];
        int max = 100000;
        ans[0] = tmap.ceilingKey(max);
        int left = 1;
        for(int i=k, j=0; i<nums.length; i++) {
            if(tmap.get(nums[j]) == 1) tmap.remove(nums[j++]);
            else tmap.put(nums[j], tmap.get(nums[j++])-1);
            tmap.put(nums[i], tmap.getOrDefault(nums[i], 0) + 1);
            ans[left++] = tmap.ceilingKey(max);
        }
        return ans;
    }
}