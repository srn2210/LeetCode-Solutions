class Solution {
public:
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size()) return false;
        int w1[26];
        int w2[26];
        memset(w1, 0, sizeof(w1));
        memset(w2, 0, sizeof(w2));
        for(auto ch : word1) {
            w1[ch-'a'] += 1;
        }
        for(auto ch : word2) {
            w2[ch-'a'] += 1;
        }
        for(int i=0; i<26; i++) {
            if(w1[i] != 0 && w2[i] == 0) return false;
        }
        sort(w1, w1 + sizeof(w1)/sizeof(w1[0]));
        sort(w2, w2 + sizeof(w2)/sizeof(w2[0]));
        for(int i=0; i<26; i++) {
            if(w1[i] != w2[i]) return false;
        }
        return true;
    }
};