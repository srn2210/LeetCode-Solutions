class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, len = words[0].length();
        var map = new HashMap<String, Integer>();
        var ans = new ArrayList<Integer>();
        for(var word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(int i=0; i<len; i++) {
            var curr = new HashMap<String, Integer>();
            int left = i, right = i + len - 1, start = i, currLen = 0;
            while(right < s.length()) {
                var str = s.substring(left, right+1);
                if(map.containsKey(str)) {
                    curr.put(str, curr.getOrDefault(str, 0) + 1);
                    if(curr.get(str).equals(map.get(str))) currLen++;
                    while(curr.get(str) > map.get(str)) {
                        var temp = s.substring(start, start+len);
                        if(map.get(temp) == curr.get(temp)) currLen--;
                        if(curr.get(temp) == 1) curr.remove(temp);
                        else curr.put(temp, curr.get(temp) - 1);
                        start += len;
                    }
                }
                else {
                    curr.clear();
                    currLen = 0;
                    start = right + 1;
                }
                if(currLen == map.size()) ans.add(start);
                left += len;
                right += len;
            }
        }
        return ans;
    }
}