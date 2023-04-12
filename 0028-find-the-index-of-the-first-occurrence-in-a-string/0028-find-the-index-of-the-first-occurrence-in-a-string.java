class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int[] pi = new int[m];
        int lps = 0;
        for(int i=1; i<m; i++) {
            while(lps != 0 && needle.charAt(i) != needle.charAt(lps)) lps = pi[lps-1];
            if(needle.charAt(i) == needle.charAt(lps)) pi[i] = ++lps;
        }
        int ptr = 0;
        for(int i=0; i<n; i++) {
            while(ptr != 0 && haystack.charAt(i) != needle.charAt(ptr)) ptr = pi[ptr-1];
            if(haystack.charAt(i) == needle.charAt(ptr)) ptr++;
            if(ptr == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }
}