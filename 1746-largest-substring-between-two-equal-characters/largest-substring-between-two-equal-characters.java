class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        List<Integer>[] map = new List[26];
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map[ch-'a'] == null) map[ch-'a'] = new ArrayList<>();
            map[ch-'a'].add(i);
        }
        for(int i=0; i<26; i++) {
            if(map[i] != null && map[i].size() >= 2) {
                ans = Math.max(ans, map[i].get(map[i].size()-1) - map[i].get(0) - 1);
            }
        }
        return ans;
    }
}