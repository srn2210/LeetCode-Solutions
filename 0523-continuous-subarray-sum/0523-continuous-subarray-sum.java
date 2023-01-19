class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if(sum != 0 && map.containsKey(sum) && i - map.get(sum) > 1) return true;
            if(sum == 0 && i != 0) return true;
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return false;
    }
}