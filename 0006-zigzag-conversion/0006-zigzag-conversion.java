class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] list = new StringBuilder[numRows+1];
        for(int i=0; i<=numRows; i++) list[i] = new StringBuilder();
        int n = 1;
        boolean sign = false;
        for(int i=0; i<s.length(); i++) {
            list[n].append(s.charAt(i));
            if(n == numRows || n == 1) sign = !sign;
            if(sign) n++;
            else n--;
        }
        StringBuilder res = new StringBuilder();
        for(int i=1; i<=numRows; i++) res.append(list[i]);
        return res.toString();
    }
}