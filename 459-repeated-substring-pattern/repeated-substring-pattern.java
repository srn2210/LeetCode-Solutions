class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1; i<=n/2; i++) {
            if(n % i == 0) {
                StringBuilder res = new StringBuilder();
                for(int j=0; j<n; j+=i) {
                    res.append(s.substring(0, i));
                }
                if(res.toString().equals(s)) return true;
            }
        }
        return false;
    }
}