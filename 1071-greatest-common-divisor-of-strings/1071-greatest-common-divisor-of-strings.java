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
    public String gcdOfStrings(String str1, String str2) {
        String a = str1.length() < str2.length() ? str1 : str2;
        String ans = "";
        for(int i=0; i<a.length(); i++) {
            String s = a.substring(0, i+1);
            if(check(s, str1) && check(s, str2) && s.length() > ans.length()) ans = s;
        }
        return ans;
    }
}