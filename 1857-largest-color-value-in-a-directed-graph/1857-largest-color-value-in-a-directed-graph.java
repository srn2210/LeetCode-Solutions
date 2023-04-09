class Solution {
    Queue<Integer> q;
    boolean kahn(Map<Integer, List<Integer>> map, int[][] edges, int n) {
        var indegree = new int[n];
        var queue = new LinkedList<Integer>();
        for(var edge : edges) indegree[edge[1]]++;
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        q = new LinkedList<>();
        q.addAll(queue);
        int[] ordering = new int[n];
        int left = -1;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            if(map.containsKey(t)) {
                for(int edge : map.get(t)) {
                    indegree[edge]--;
                    if(indegree[edge] == 0) queue.add(edge);
                }
            }
            ordering[++left] = t;
        }
        if(left != n-1) return true;
        return false;
    }
    int[] dfs(int src, Map<Integer, List<Integer>> map, int[] coloring, String colors, Map<Integer, int[]> dp) {
        int color = colors.charAt(src) - 'a';
        //coloring[color]++;
        //int ans = Integer.MIN_VALUE;
        if(!map.containsKey(src)) {
            //for(int i : coloring) ans = Math.max(ans, i);
            int[] temp = new int[26];
            temp[color]++;
            dp.put(src, Arrays.copyOf(temp, temp.length));
            //coloring[color]--;
            return temp;
        }
        if(dp.containsKey(src)) {
            return dp.get(src);
        }
        int[] ans = new int[26];
        for(int i : map.get(src)) {
            //ans = Math.max(ans, dfs(i, map, coloring, colors));
            int[] a = dfs(i, map, coloring, colors, dp);
            for(int j=0; j<26; j++) {
                ans[j] = Math.max(ans[j], a[j]);
            }
        }
        ans[color]++;
        dp.put(src, Arrays.copyOf(ans, ans.length));
        //coloring[color]--;
        return ans;
    }
    public int largestPathValue(String colors, int[][] edges) {
        //if(edges.length == 0) return 1;
        int n = 0;
        var map = new HashMap<Integer, List<Integer>>();
        for(var edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
            map.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
        }
        n += 1;
        if(kahn(map, edges, n)) return -1;
        boolean[] vis = new boolean[n];
        int[] coloring = new int[26];
        int ans = Integer.MIN_VALUE;
        var dp = new HashMap<Integer, int[]>();
        while(!q.isEmpty()) {
            int node = q.poll();
            int[] arr = dfs(node, map, coloring, colors, dp);
            for(int i : arr) ans = Math.max(i, ans);
        }
        return ans;
    }
}