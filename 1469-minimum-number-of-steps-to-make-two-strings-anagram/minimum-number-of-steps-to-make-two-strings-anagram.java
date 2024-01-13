class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for(char ch : s.toCharArray()) {
            map[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            map[ch-'a']--;
        }
        int count = 0;
        for(int i : map) {
            if(i > 0) count += i;
        }
        return count;
    }
}