class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            char ct = t.charAt(i);
            map[ch-'a']++;
            map[ct-'a']--;
        }
        int count = 0;
        for(int i : map) {
            if(i > 0) count += i;
        }
        return count;
    }
}