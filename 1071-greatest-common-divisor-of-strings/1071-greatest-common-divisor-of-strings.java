class Solution {
    boolean check(String s, String str) {
        int sz1 = str.length();
        int sz2 = s.length();
        if(sz1 % sz2 != 0) return false;
        int end = sz1 / sz2;
        int s1 = 0;
        int s2 = 0;
        while(s1 < sz1) {
            if(s.charAt(s2++ % sz2) != str.charAt(s1++)) return false;
        }
        return s1 == sz1 && s2 == sz1;
    }
    int gcd(int s1, int s2) {
        if(s2 > s1) return gcd(s2, s1);
        else if(s1 == 0) return s2;
        else if(s2 == 0) return s1;
        else return gcd(s1-s2, s2);
    }
    public String gcdOfStrings(String str1, String str2) {
        int hcf = gcd(str1.length(), str2.length());
        String ans = str1.substring(0, hcf);
        if(check(ans, str1) && check(ans, str2)) return ans;
        return "";
    }
}