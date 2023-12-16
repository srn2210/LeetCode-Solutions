class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> arr(26, 0);
        for(auto ch : s) {
            arr[ch-'a']++;
        }
        for(auto ch : t) {
            arr[ch-'a']--;
        }
        for(auto a : arr) {
            if(a) return false;
        }
        return true;
    }
};