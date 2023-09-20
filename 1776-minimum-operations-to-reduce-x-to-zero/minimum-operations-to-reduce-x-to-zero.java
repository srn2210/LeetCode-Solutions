class Solution {
    public int minOperations(int[] nums, int x) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        int preSum = 0;
        for(int i=0; i<nums.length; i++) {
            preSum += nums[i];
            map.put(preSum, i+1);
        }
        int end = nums.length-1, sum = 0, min = nums.length+1;
        while(end >= -1) {
            int rem = x - sum;
            if(rem < 0) break;
            int ind = map.getOrDefault(rem, -1);
            if(end-1 >= 0) sum += nums[end];
            end--;
            if(ind < 0) continue;
            else {
                int count = ind + nums.length - end - 2;
                min = Math.min(min, count);
            }
        }
        return min == nums.length+1 ? -1 : min;
    }
}