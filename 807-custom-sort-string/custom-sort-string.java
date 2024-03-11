class Solution {
    public String customSortString(String order, String s) {
        var map = new HashMap<Character, Integer>();
        var ans = new StringBuilder();
        var set = new HashSet<Character>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch : order.toCharArray()) {
            if(map.containsKey(ch)) {
                for(int i=0; i<map.get(ch); i++) {
                    ans.append(ch);
                }
                set.add(ch);
            }
        }
        for(var entry : map.entrySet()) {
            if(!set.contains(entry.getKey())) {
                for(int i=0; i<entry.getValue(); i++) ans.append(entry.getKey());
            }
        }
        return ans.toString();
    }
}