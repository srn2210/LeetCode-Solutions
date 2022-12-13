class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int map[26];
        memset(map, 0, sizeof(map));
        for(auto ch : s1) map[ch - 'a']++;
        int left = 0;
        int right = 0;
        while(right < s2.length()) {
            if(map[s2[right] - 'a'] > 0) {
                if(right - left + 1 == s1.size()) return true;
                map[s2[right++] - 'a']--;
            }
            else {
                map[s2[left++] - 'a']++;
            }
        }
        return false;
    }
};