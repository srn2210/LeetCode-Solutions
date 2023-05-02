class Solution {
    int j;
    int evaluate(String s, int idx) {
        int sign = 1;
        int curr = 0;
        int res = 0;
        for(int i=idx; i<s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '+':
                    res += sign * curr;
                    curr = 0;
                    sign = 1;
                    break;
                case '-':
                    res += sign * curr;
                    curr = 0;
                    sign = -1;
                    break;
                case '(':
                    res += evaluate(s, i+1) * sign;
                    i = j;
                    curr = 0;
                    sign = 1;
                    break;
                case ')':
                    res += sign * curr;
                    j = i;
                    return res;
                case ' ':
                    break;
                default:
                    curr = curr * 10 + Character.getNumericValue(ch);
            }
        }
        return res;
    }
    public int calculate(String s) {
        int sign = 1;
        int curr = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '+':
                    res += sign * curr;
                    curr = 0;
                    sign = 1;
                    break;
                case '-':
                    res += sign * curr;
                    curr = 0;
                    sign = -1;
                    break;
                case '(':
                    int t = evaluate(s, i+1) * sign;
                    res += t;
                    i = j;
                    curr = 0;
                    sign = 1;
                    break;
                case ' ':
                    break;
                default:
                    curr = curr * 10 + Character.getNumericValue(ch);
            }
        }
        return res + (curr * sign);
    }
}