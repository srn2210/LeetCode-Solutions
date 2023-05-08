class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] diff = new int[1000002];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                diff[Math.abs(nums[i]-nums[j])]++;
            }
        }
        for(int i=0; i<diff.length; i++) {
            if(k <= diff[i]) return i;
            k -= diff[i];
        }
        return 0;
    }
}