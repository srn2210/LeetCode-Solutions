class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        int[] map = new int[26];
        for(char ch : p.toCharArray()) map[ch-'a']++;
        while(left < s.length() && right < s.length()) {
            if(map[s.charAt(right)-'a'] > 0) {
                map[s.charAt(right)-'a']--;
                if(right - left + 1 == p.length()) ans.add(left);
                right++;
            }
            else {
                map[s.charAt(left)-'a']++;
                left++;
            }
        }
        return ans;
    }
}