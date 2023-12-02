class Solution {
    int[] map(String word) {
        int[] ans = new int[26];
        for(char ch : word.toCharArray()) {
            ans[ch-'a']++;
        }
        return ans;
    }
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] count = map(chars);
        for(String word : words) {
            int[] curr = map(word);
            boolean flag = true;
            for(int i=0; i<26; i++) {
                if(count[i] < curr[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) ans += word.length();
        }
        return ans;
    }
}