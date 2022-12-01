class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        boolean sign = true;
        boolean flag = false;
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                if(flag) break;
                continue;
            }
            else if(ch == '-') {
                if(flag) break;
                flag = true;
                sign = false;
            }
            else if(ch == '+') {
                if(flag) break;
                flag = true;
            }
            else if(ch >= '0' && ch <= '9') {
                flag = true;
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