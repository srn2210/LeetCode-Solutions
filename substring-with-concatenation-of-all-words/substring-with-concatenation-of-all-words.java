class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, len = words[0].length();
        var map = new HashMap<String, Integer>();
        var ans = new ArrayList<Integer>();
        for(var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int left = 0, right = (n * len) - 1;
        var curr = new HashMap<String, Integer>();
        while(right < s.length()) {
            int t = left;
            for(int i=0; i<n; i++) {
                var str = s.substring(t, t+len);
                curr.put(str, curr.getOrDefault(str, 0) + 1);
                if(!map.containsKey(str) || curr.get(str) > map.get(str)) {
                    curr.clear();
                    break;
                }
                if(i == n-1) {
                    ans.add(left);
                    curr.clear();
                }
                t += len;
            }
            left++;
            right++;
        }
        return ans;
    }
}