class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        /*int n = nums.length, init = n-1, idx = 0;
        while(init < k) {
            idx++;
            k -= init;
            init = n - idx - 1;
        }
        System.out.println(Arrays.toString(nums));
        return Math.abs(nums[idx] - nums[idx+k]);*/
        /*for(int i=0; i<nums.length-1; i++) {
            binarySearch(i+1, nums.length-1, nums, )
        }*/
        //k = 2 * k;
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