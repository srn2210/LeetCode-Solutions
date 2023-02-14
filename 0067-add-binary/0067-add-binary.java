class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        StringBuilder t1 = new StringBuilder(a);
        a = t1.reverse().toString();
        StringBuilder t2 = new StringBuilder(b);
        b = t2.reverse().toString();
        boolean carry = false;
        int one = 0;
        while(one<a.length() && one<b.length()) {
            if(a.charAt(one) == '1' && b.charAt(one) == '1') {
                if(carry) res.append('1');
                else {
                    res.append('0');
                    carry = true;
                }
            }
            else if(a.charAt(one) == '0' && b.charAt(one) == '0') {
                if(carry) {
                    res.append('1');
                    carry = false;
                }
                else res.append('0');
            }
            else {
                if(carry) res.append('0');
                else res.append('1');
            }
            one++;
        }
        while(one < a.length()) {
            if(a.charAt(one) == '1' && carry) res.append('0');
            else if(a.charAt(one) == '1' && !carry) res.append('1');
            else if(a.charAt(one) == '0' && carry) {
                res.append('1');
                carry = false;
            }
            else res.append('0');
            one++;
        }
        while(one < b.length()) {
            if(b.charAt(one) == '1' && carry) res.append('0');
            else if(b.charAt(one) == '1' && !carry) res.append('1');
            else if(b.charAt(one) == '0' && carry) {
                res.append('1');
                carry = false;
            }
            else res.append('0');
            one++;
        }
        if(carry) res.append('1');
        res = res.reverse();
        return res.toString();
    }
}