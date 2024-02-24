class Solution {
    public int maximumLength(String s) {
        int left = 0, right = 0;
        int ans = -1;
        var map = new HashMap<Pair<Character, Integer>, Integer>();
        while(left <= right && right < s.length()) {
            while(right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            int len = right - left;
            for(int i=0; i<len; i++) {
                var p = new Pair<Character, Integer>(s.charAt(left), len - i);
                int occurences = i + 1;
                if(map.containsKey(p)) {
                    map.put(p, map.get(p)+occurences);
                }
                else {
                    map.put(p, occurences);
                }
                if(map.get(p) >= 3) ans = Math.max(ans, len - i);
            }
            left = right;
        }
        return ans;
    }
}