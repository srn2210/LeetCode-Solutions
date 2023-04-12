class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int[] lps = new int[m];
        int prev = 0, curr = 1;
        while(curr < m) {
            if(needle.charAt(curr) == needle.charAt(prev)) {
                lps[curr] = ++prev;
                curr++;
            }
            else {
                if(prev == 0) curr++;
                else prev = lps[prev-1];
            }
        }
        curr = 0; prev = 0;
        while(curr < n) {
            if(haystack.charAt(curr) == needle.charAt(prev)) {
                prev++;
                curr++;
                if(prev == m) return curr - m;
            }
            else {
                if(prev == 0) curr++;
                else prev = lps[prev-1];
            }
        }
        return -1;
    }
}