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
        int left = -1;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            if(map.containsKey(t)) {
                for(int edge : map.get(t)) {
                    indegree[edge]--;
                    if(indegree[edge] == 0) queue.add(edge);
                }
            }
            ++left;
        }
        if(left != n-1) return true;
        return false;
    }
    int[] dfs(int src, Map<Integer, List<Integer>> map, String colors, Map<Integer, int[]> dp) {
        int color = colors.charAt(src) - 'a';
        if(!map.containsKey(src)) {
            int[] temp = new int[26];
            temp[color]++;
            dp.put(src, temp);
            return temp;
        }
        if(dp.containsKey(src)) return dp.get(src);
        int[] ans = new int[26];
        for(int i : map.get(src)) {
            int[] a = dfs(i, map, colors, dp);
            for(int j=0; j<a.length; j++) {
                ans[j] = Math.max(ans[j], a[j]);
            }
        }
        ans[color]++;
        dp.put(src, ans);
        return ans;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = 0;
        var map = new HashMap<Integer, List<Integer>>();
        for(var edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
            map.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
        }
        n += 1;
        if(kahn(map, edges, n)) return -1;
        int ans = Integer.MIN_VALUE;
        var dp = new HashMap<Integer, int[]>();
        while(!q.isEmpty()) {
            int node = q.poll();
            int[] arr = dfs(node, map, colors, dp);
            for(int i : arr) ans = Math.max(i, ans);
        }
        return ans;
    }
}