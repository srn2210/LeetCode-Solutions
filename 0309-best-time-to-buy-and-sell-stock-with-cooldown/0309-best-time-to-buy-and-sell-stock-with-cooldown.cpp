class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int buy[n];
        int sell[n];
        memset(buy, 0, sizeof(buy));
        memset(sell, 0, sizeof(sell));
        buy[0] = -prices[0];
        sell[0] = 0;
        if(n == 1) return sell[0];
        buy[1] = max(-prices[1], buy[0]);
        sell[1] = max(prices[1] + buy[0], 0);
        for(int i=2; i<n; i++) {
            buy[i] = max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = max(prices[i] + buy[i-1], sell[i-1]);
        }
        return max(buy[n-1], sell[n-1]);
    }
};