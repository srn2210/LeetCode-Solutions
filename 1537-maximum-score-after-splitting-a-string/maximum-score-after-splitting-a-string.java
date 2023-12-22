class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int total = 0, curr = 0;
        for(char ch : s.toCharArray()) total += ch - '0';
        for(int i=0; i<s.length()-1; i++) {
            char ch = s.charAt(i);
            curr += (ch - '0') ^ 1;
            total -= ch - '0';
            ans = Math.max(ans, curr + total);
        }
        return ans;
    }
}