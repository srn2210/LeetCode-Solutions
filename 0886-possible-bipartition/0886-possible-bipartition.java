class Solution {
    boolean dfs(Map<Integer, List<Integer>> map, int src, int col, int[] color) {
        if(!map.containsKey(src)) return true;
        color[src] = col;
        List<Integer> list = map.get(src);
        for(int i : list) {
            if(color[src] == color[i]) return false;
            if(color[i] == -1 && !dfs(map, i, 1 - col, color)) return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
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
            if(color[j] == -1) {
                if(!dfs(map, j, 0, color)) return false;
            }
        }
        return true;
    }
}