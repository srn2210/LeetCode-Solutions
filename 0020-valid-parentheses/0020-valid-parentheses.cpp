class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(char ch: s) {
            if(!st.empty() && st.top() == '(' && ch == ')') st.pop();
            else if(!st.empty() && st.top() == '[' && ch == ']') st.pop();
            else if(!st.empty() && st.top() == '{' && ch == '}') st.pop();
            else st.push(ch);
        }
        return st.empty();
    }
};