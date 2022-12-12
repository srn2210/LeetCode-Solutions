class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int set[128];
        memset(set, 0, sizeof(set));
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < s.size()) {
            if(!set[s[right]]) {
                ans = max(ans, right-left+1);
                set[s[right++]]++;
            }
            else {
                set[s[left++]]--;
            }
        }
        return ans;
    }
};