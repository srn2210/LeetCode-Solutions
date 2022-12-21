class Solution {
    boolean dfs(Map<Integer, List<Integer>> map, int src, int col, Set<Integer> set1, Set<Integer> set2) {
        if(!map.containsKey(src)) {
            set1.add(src);
            return true;
        }
        if(col == 0) set1.add(src);
        if(col == 1) set2.add(src);
        if(set1.contains(src)) {
            for(int i : map.get(src)) {
                if(set1.contains(i)) return false;
                if(!set2.contains(i) && !dfs(map, i, 1-col, set1, set2)) return false;
            }
        }
        if(set2.contains(src)) {
            for(int i : map.get(src)) {
                if(set2.contains(i)) return false;
                if(!set1.contains(i) && !dfs(map, i, 1-col, set1, set2)) return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int[] i : dislikes) {
            if(!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<>());
            }
            List<Integer> temp = map.get(i[0]);
            temp.add(i[1]);
            if(!map.containsKey(i[1])) {
                map.put(i[1], new ArrayList<>());
            }
            temp = map.get(i[1]);
            temp.add(i[0]);
        }
        for(int j=1; j<=n; j++) {
            if(!set1.contains(j) && !set2.contains(j)) {
                if(!dfs(map, j, 0, set1, set2)) return false;
            }
        }
        return true;
    }
}