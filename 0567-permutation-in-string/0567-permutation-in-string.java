class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int map[] = new int[26];
        for(char ch:s1.toCharArray()) {
            map[ch-'a']++;
        }
        int left = 0;
        int right = 0;
        while(right < s2.length()) {
            if(map[s2.charAt(right)-'a'] > 0) {
                map[s2.charAt(right)-'a']--;
                if(right - left + 1 == s1.length()) return true;
                right++;
            }
            else {
                map[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
    }
}