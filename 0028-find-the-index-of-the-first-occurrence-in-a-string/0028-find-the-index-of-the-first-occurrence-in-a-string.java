class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int[] pi = new int[m];
        int lps = 0, j = 1;
        while(j < m) {
            if(needle.charAt(j) == needle.charAt(lps)) {
                pi[j] = ++lps;
                j++;
            }
            else {
                if(lps == 0) j++;
                else lps = pi[lps-1];
            }
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