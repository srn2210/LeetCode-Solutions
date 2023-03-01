class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*Map<Character, Integer>[] map = new Map[strs.length];
        for(int i=0; i<strs.length; i++) map[i] = new HashMap<>();
        int idx = 0;
        for(var s : strs) {
            for(char ch : s) {
                map[i].put(ch, map[i].getOrDefault(ch,0)+1);
            }
            idx++;
        }*/
        /*String[][] arr = new String[strs.length][2];
        for(int i=0; i<strs.length; i++) {
            arr[i][0] = strs[i];
            arr[i][1] = String.valueOf(i);
        }
        for(int i=0; i<arr.length; i++) {
            Arrays.sort(arr[i][0]);
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0].length(), b[0].length()));
        for(int i=0; i<arr.length; i++) System.out.println(Arrays.toString(arr[i]));*/
        Map<Set<Map.Entry<Character, Integer>>, List<String>> map = new HashMap<>();
        for(var s : strs) {
            Map<Character, Integer> m = new HashMap<>();
            for(char ch : s.toCharArray()) m.put(ch, m.getOrDefault(ch, 0) + 1);
            map.computeIfAbsent(m.entrySet(), arr -> new ArrayList<>()).add(s);
        }
        //System.out.println(map.entrySet());
        return new ArrayList<>(map.values());
    }
}