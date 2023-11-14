class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        int[] pre = new int[26];
        int[] post = new int[26];
        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            post[ch-'a']++;
        }
        pre[s.charAt(0)-'a']++;
        boolean[][] seen = new boolean[26][26];
        for(int j=1; j<s.length()-1; j++) {
            char ch = s.charAt(j);
            post[ch-'a']--;
            for(int i=0; i<26; i++) {
                if(seen[ch-'a'][i]) continue;
                if(pre[i] > 0 && post[i] > 0) {
                    count++;
                    seen[ch-'a'][i] = true;
                }
            }
            pre[ch-'a']++;
        }
        return count;
    }
}