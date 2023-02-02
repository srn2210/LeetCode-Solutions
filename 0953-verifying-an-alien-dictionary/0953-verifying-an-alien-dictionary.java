class Solution {
    boolean check(String s1, String s2, int[] map) {
        for(int i=0; i<s1.length(); i++) {
            if(i >= s2.length()) return false;
            if(map[s1.charAt(i)-'a'] < map[s2.charAt(i)-'a']) return true;
            if(map[s1.charAt(i)-'a'] > map[s2.charAt(i)-'a']) return false;
        }
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        int k = 0;
        for(char ch : order.toCharArray()) map[ch-'a'] = k++;
        for(int i=0; i<words.length-1; i++) {
            if(!check(words[i], words[i+1], map)) return false;
        }
        return true;
    }
}