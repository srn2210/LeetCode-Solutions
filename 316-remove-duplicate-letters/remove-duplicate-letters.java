class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        var set = new boolean[26];
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++) map[s.charAt(i)-'a']++;
        for(char ch : s.toCharArray()) {
            int ind = ch - 'a';
            if(res.isEmpty()) {
                res.append(ch);
                set[ch-'a'] = true;
            }
            while(!res.isEmpty() && res.charAt(res.length()-1) > ch && map[res.charAt(res.length()-1)-'a'] > 0 && !set[ch-'a']) {
                char c = res.charAt(res.length()-1);
                res.deleteCharAt(res.length()-1);
                set[c-'a'] = false;
            }
            if(!set[ch-'a']) {
                res.append(ch);
                set[ch-'a'] = true;
            }
            map[ind]--;
        }
        return res.toString();
    }
}