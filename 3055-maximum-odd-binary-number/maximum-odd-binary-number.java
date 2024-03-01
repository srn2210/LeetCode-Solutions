class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '1') count++;
        }
        var str = new StringBuilder();
        while(count-- > 1) {
            str.append('1');
        }
        while(str.length() < s.length() - 1) str.append('0');
        str.append('1');
        return str.toString();
    }
}