class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        bool dp[s.size()];
        memset(dp, false, sizeof(dp));
        unordered_set<string> set;
        for(string ss : wordDict) set.insert(ss);
        for(int i=0; i<s.size(); i++) {
            for(int j=i; j<s.size(); j++) {
                string t = s.substr(i, j-i+1);
                if(set.find(t) != set.end()) {
                    if(i-1 >= 0 && dp[i-1]) dp[j] = true;
                    else if(i == 0) dp[j] = true;
                }
            }
        }
        return dp[s.size()-1];
    }
};