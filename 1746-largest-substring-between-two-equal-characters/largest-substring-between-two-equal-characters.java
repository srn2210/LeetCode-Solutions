class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int[][] map = new int[26][2];
        for(int[] m : map) Arrays.fill(m, -1);
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map[ch-'a'][0] == -1) map[ch-'a'][0] = i;
            else map[ch-'a'][1] = i;
        }
        for(int i=0; i<26; i++) {
            if(map[i][0] != -1 && map[i][1] != -1) {
                ans = Math.max(ans, map[i][1] - map[i][0] - 1);
            }
        }
        return ans;
    }
}