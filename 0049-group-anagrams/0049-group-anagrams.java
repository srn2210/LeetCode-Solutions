class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(var s : strs) {
            int[] a = new int[26];
            for(char ch : s.toCharArray()) a[ch-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++) {
                sb.append(',');
                sb.append(a[i]);
            }
            map.computeIfAbsent(sb.toString(), arr -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}