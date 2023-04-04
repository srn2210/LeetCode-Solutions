class Solution {
    public int partitionString(String s) {
        var map = new HashSet<Character>();
        int ans = 1;
        for(char ch : s.toCharArray()) {
            if(map.contains(ch)) {
                ans++;
                map.clear();
            }
            map.add(ch);
        }
        return ans;
    }
}