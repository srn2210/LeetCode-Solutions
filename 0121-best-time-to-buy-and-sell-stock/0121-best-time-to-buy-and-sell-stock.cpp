class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int m = INT_MAX;
        for(int price : prices) {
            ans = max(ans, price - m);
            m = min(m, price);
        }
        return ans;
    }
};