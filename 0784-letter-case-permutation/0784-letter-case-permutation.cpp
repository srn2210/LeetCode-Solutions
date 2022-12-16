class Solution {
public:
    void backtrack(string s, vector<string>& res, int j) {
        res.push_back(s);
        for(int i=j; i<s.size(); i++) {
            if(s[i] <= 'z' && s[i] >= 'a') {
                s[i] -= 32;
                backtrack(s, res, i+1);
                s[i] += 32;
            }
            else if(s[i] <= 'Z' && s[i] >= 'A') {
                s[i] += 32;
                backtrack(s, res, i+1);
                s[i] -= 32;
            }
        }
    }
    vector<string> letterCasePermutation(string s) {
        vector<string> res;
        backtrack(s, res, 0);
        return res;
    }
};