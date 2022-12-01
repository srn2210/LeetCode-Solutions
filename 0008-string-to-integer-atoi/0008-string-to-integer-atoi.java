class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        int flag = 0;
        for(char ch : s.toCharArray()) {
            if(flag == 2) break;
            if(ch == ' ') {
                if(flag == 1) flag = 2;
                continue;
            }
            else if(ch == '-') {
                if(flag == 1) {
                    flag = 2;
                    continue;
                }
                flag = 1;
                sign = sign * -1;
            }
            else if(ch == '+') {
                if(flag == 1) {
                    flag = 2;
                    continue;
                }
                flag = 1;
                continue;
            }
            else if(ch >= '0' && ch <= '9') {
                flag = 1;
                if(sign == 1) ans = (ans * 10) + (ch - '0');
                if(sign == -1) ans = (ans * 10) - (ch - '0');
                if(ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                else if(ans < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            else {
                //flag = 2;
                break;
            }
        }
        return (int) ans;
    }
}