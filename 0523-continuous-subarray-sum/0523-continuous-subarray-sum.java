class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0,0));
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if(!map.containsKey(sum)) map.put(sum, i+1);
            else if(map.get(sum) < i) return true;
        }
        return false;
    }
}