class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        int[] map = new int[26];
        for(char ch : s.toCharArray()) map[ch-'a']++;
        for(int i=0; i<26; i++) {
            char ch = (char)(i + 'a');
            for(int j=0; j<26; j++) {
                if(i == j || map[i] == 0 || map[j] == 0) continue;
                char c = (char)(j + 'a');
                int c1 = 0, c2 = 0, c3 = map[j];
                for(int k=0; k<s.length(); k++) {
                    char curr = s.charAt(k);
                    if(curr == ch) c1++;
                    else if(curr == c) {
                        c2++;
                        c3--;
                    }
                    if(c2 != 0) ans = Math.max(ans, c1 - c2);
                    if(c1 < c2 && c3 > 0) {
                        c1 = 0;
                        c2 = 0;
                    }
                }
            }
        }
        return ans;
    }
}