class Solution {
    boolean deScramble(String s1, int start, int end, String s2, int left, int right, Boolean[][][][] memo) {
        if(start == end) return s1.charAt(start) == s2.charAt(left);
        if(memo[start][end][left][right] != null) return memo[start][end][left][right];
        boolean ans = false;
        for(int i=start; i<end; i++) {
            if(deScramble(s1, start, i, s2, left, left+i-start, memo) && deScramble(s1, i+1, end, s2, left+i-start+1, right, memo)) ans = true;
            if(deScramble(s1, i+1, end, s2, left, left+end-i-1, memo) && deScramble(s1, start, i, s2, left+end-i, right, memo)) ans = true;
        }
        return memo[start][end][left][right] = ans;
    }
    public boolean isScramble(String s1, String s2) {
        Boolean[][][][] memo = new Boolean[s1.length()][s1.length()][s1.length()][s1.length()];
        return deScramble(s1, 0, s1.length()-1, s2, 0, s2.length()-1, memo);
    }
}