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
                    curr += evaluate(s, i+1) * sign;
                    i = j;
                    //curr = 0;
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
        return res + (curr * sign);
    }
    public int calculate(String s) {
        return evaluate(s, 0);
    }
}