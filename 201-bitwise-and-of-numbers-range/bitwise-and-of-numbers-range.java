class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // if(left == right) return left;
        // int low = (int)(Math.log(left) / Math.log(2));
        // int high = (int)(Math.log(right) / Math.log(2));
        // System.out.println((int)(Math.pow(2, 31)- Math.pow(2, 30)));
        // return low == high ? (int)Math.pow(2, low) : 0;
        // return left & right;
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
        // System.out.println(s1 + " --- " + s2);
        for(int i=0; i<31; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                if(s1.charAt(i) == '1') ans = ans | (1 << (31 - i - 1));
            }
            else break;
        }
        return ans;
    }
}