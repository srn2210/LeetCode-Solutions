class Solution {
    public int maxProfit(int[] prices) {
        int sol = 0, min = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            sol = Math.max(prices[i] - min, sol);
        }
        
        return sol;
    }
}