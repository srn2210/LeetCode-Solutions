class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        StringBuilder arev = new StringBuilder(a);
        StringBuilder brev = new StringBuilder(b);
        arev = arev.reverse();
        brev = brev.reverse();
        int len = a.length() > b.length() ? b.length() : a.length();
        char carry = '0';
        for(int i=0; i<len; i++) {
            if(arev.charAt(i) == '0' && brev.charAt(i) == '0') {
                if(carry == '1') {
                    res.append('1');
                    carry = '0';
                }
                else {
                    res.append('0');
                }
            }
            else if(arev.charAt(i) == '0' && brev.charAt(i) == '1' || arev.charAt(i) == '1' && brev.charAt(i) == '0') {
                if(carry == '1') {
                    res.append('0');
                    carry = '1';
                }
                else {
                    res.append('1');
                }
            }
            else {
                if(carry == '1') {
                    res.append('1');
                    carry = '1';
                }
                else {
                    res.append('0');
                    carry = '1';
                }
            }
        }
        
        
        if(a.length() == b.length()) {
            if(carry == '1') res.append('1');
            return res.reverse().toString();
        }
        
        int glen = 0;
        StringBuilder s = new StringBuilder();
        
        if(a.length() > b.length()) {
            glen = a.length();
            s = arev;
        }
        else {
            glen = b.length();
            s = brev;
        }
        
        for(int i=len; i<glen; i++) {
            if(s.charAt(i) == '0') {
                if(carry == '1') {
                    res.append('1');
                    carry = '0';
                }
                else {
                    res.append('0');
                }
            }
            else if(s.charAt(i) == '1') {
                if(carry == '1') {
                    res.append('0');
                    carry = '1';
                }
                else {
                    res.append('1');
                }
            }
        }
        
        
        if(carry == '1') res.append('1');
        
        return res.reverse().toString();
    }
}