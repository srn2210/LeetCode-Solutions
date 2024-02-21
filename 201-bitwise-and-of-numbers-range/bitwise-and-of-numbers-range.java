class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        var s1 = Integer.toBinaryString(left);
        var s2 = Integer.toBinaryString(right);
        if(s1.length() < 31) {
            var sbr = new StringBuilder();
            for(int i=0; i<(31-s1.length()); i++) sbr.append('0');
            sbr.append(s1);
            s1 = sbr.toString();
        }
        if(s2.length() < 31) {
            var sbr = new StringBuilder();
            for(int i=0; i<(31-s2.length()); i++) sbr.append('0');
            sbr.append(s2);
            s2 = sbr.toString();
        }
        for(int i=0; i<31; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                if(s1.charAt(i) == '1') ans = ans | (1 << (31 - i - 1));
            }
            else break;
        }
        return ans;
    }
}