class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        boolean sign = true;
        int flag = 0;
        for(char ch : s.toCharArray()) {
            if(flag == 2) break;
            if(ch == ' ') {
                if(flag == 1) break;
                continue;
            }
            else if(ch == '-') {
                if(flag == 1) break;
                flag = 1;
                sign = false;
            }
            else if(ch == '+') {
                if(flag == 1) break;
                flag = 1;
                continue;
            }
            else if(ch >= '0' && ch <= '9') {
                flag = 1;
                if(sign) {
                    ans = (ans * 10) + (ch - '0');
                    if(ans > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                else {
                    ans = (ans * 10) - (ch - '0');
                    if(ans < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            else {
                break;
            }
        }
        return (int) ans;
    }
}