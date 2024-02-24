class Solution {
    public int maximumLength(String s) {
        int left = 0, right = 0;
        int ans = -1;
        var map = new HashMap<Character, Map<Integer, Integer>>();
        while(left <= right && right < s.length()) {
            while(right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            int len = right - left;
            for(int i=0; i<len; i++) {
                char ch = s.charAt(left);
                int currLen = len - i;
                int occurences = i + 1;
                map.computeIfAbsent(ch, a -> new HashMap<>()).put(currLen, map.get(ch).getOrDefault(currLen, 0) + occurences);
                if(map.get(ch).get(currLen) >= 3) ans = Math.max(ans, currLen);
            }
            left = right;
        }
        return ans;
    }
}