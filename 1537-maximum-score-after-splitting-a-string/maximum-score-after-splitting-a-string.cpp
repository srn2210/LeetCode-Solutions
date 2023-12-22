class Solution {
public:
    int maxScore(string s) {
        int ans = 0, curr = 0, total = 0;
        for(auto ch : s) total += ch - '0';
        for(int i=0; i<s.size()-1; i++) {
            curr += ((s[i] - '0') ^ 1);
            total -= s[i] - '0';
            ans = max(ans, curr + total);
        }
        return ans;
    }
};