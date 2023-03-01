class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] a = new int[26];
        for(var s : strs) {
            Arrays.fill(a, 0);
            for(char ch : s.toCharArray()) a[ch-'a']++;
            map.computeIfAbsent(Arrays.toString(a), arr -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}