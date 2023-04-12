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
        
        //System.out.println(Arrays.toString(pi));
        int ptr = -1;
        for(int i=0; i<haystack.length(); i++) {
            while(ptr != -1 && haystack.charAt(i) != needle.charAt(ptr+1)) ptr = pi[ptr]-1;
            //System.out.println(i + "  " + ptr);
            if(haystack.charAt(i) == needle.charAt(ptr+1)) ptr++;
            if(ptr == needle.length() - 1) return i - needle.length() + 1;
        }
        return -1;
    }
}