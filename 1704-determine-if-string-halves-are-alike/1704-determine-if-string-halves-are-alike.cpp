class Solution {
public:
    bool check(char ch) {
        if(ch <= 'Z') ch += 32;
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    bool halvesAreAlike(string s) {
        int ans = 0;
        for(int i=0; i<s.size(); i++) {
            if(i < s.size()/2 && check(s[i])) ans++;
            else if(i >= s.size()/2 && check(s[i])) ans--;
        }
        return ans == 0;
    }
};