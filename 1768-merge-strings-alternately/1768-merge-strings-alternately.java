class Solution {
    public String mergeAlternately(String word1, String word2) {
        int s1 = 0;
        int s2 = 0;
        StringBuilder ans = new StringBuilder();
        while(s1 < word1.length() || s2 < word2.length()) {
            if(s1 < word1.length()) ans.append(word1.charAt(s1++));
            if(s2 < word2.length()) ans.append(word2.charAt(s2++));
        }
        return ans.toString();
    }
}