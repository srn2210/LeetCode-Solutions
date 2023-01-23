class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            set.add(i);
        }
        for(int[] t : trust) {
            set.remove(t[0]);
            map.put(t[1], map.getOrDefault(t[1], 0) + 1);
        }
        if(set.size() == 0) return -1;
        for(int s : set) {
            if(map.getOrDefault(s, 0) == n-1) return s;
        }
        return -1;
    }
}