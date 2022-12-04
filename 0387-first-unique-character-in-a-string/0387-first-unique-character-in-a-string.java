class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for(char ch : s.toCharArray()) {
            map[ch - 'a'] += 1;
        }
        for(int i=0; i<s.length(); i++) {
            if(map[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}