class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        TreeMap<Integer, Integer> tm = new TreeMap();
        int ans = Integer.MIN_VALUE;
        
        
        for(int i=0; i<nums.length; i++) {
            /*for(int j=i; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
                else if(nums[j] == nums[i] && i != j) {
                    dp[i] = dp[j];
                    break;
                }
            }*/
            Integer prev = tm.floorKey(nums[i]);
            
            //System.out.println("nums val = "+nums[i]+".... prev val = "+prev);
            int max = 0;
            if(prev != null) {
                for(Map.Entry num:tm.entrySet()) {
                    if((int) num.getKey() >= nums[i]) break;
                    max = Math.max(tm.get(num.getKey()), max);
                }
            }
            
            if(prev != null) {
                tm.put(nums[i], max+1);
            }
            else {
                if(tm.containsKey(nums[i])) {
                    continue;
                }
                else {
                    tm.put(nums[i], 1);
                }
            }
            
            //if(dp[i] == 0) dp[i] = 1;
            ans = Math.max(tm.get(nums[i]), ans);
        }
        
        /*for(Map.Entry entry:tm.entrySet()) {
            System.out.println("key = "+entry.getKey()+"... val = "+entry.getValue());
        }*/
        
        return ans;
    }
}