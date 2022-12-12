class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < s.size()) {
            if(!set.count(s[right])) {
                ans = max(ans, right-left+1);
                set.insert(s[right++]);
            }
            else {
                set.erase(s[left++]);
            }
        }
        return ans;
    }
};