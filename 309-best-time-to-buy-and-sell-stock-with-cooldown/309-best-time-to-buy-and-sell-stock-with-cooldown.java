class Solution {
    public int maxProfit(int[] prices) {        
        int n = prices.length;
        
        if(n == 1) return 0;
        
        if(n == 2) return Math.max(0, prices[1] - prices[0]);
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(sell[0] - prices[1], buy[0]);
        sell[1] = Math.max(buy[0] + prices[1], sell[0]);
        
        for(int i=2; i<n; i++){
            buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
        }
        
        return Math.max(buy[n-1], sell[n-1]);
    }
}