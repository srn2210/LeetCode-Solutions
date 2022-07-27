class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0,1);
        int count = 0, sum = 0;
        
        for(int i:nums){
            sum += i;
            count += hm.getOrDefault(sum-k,0);
            
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}