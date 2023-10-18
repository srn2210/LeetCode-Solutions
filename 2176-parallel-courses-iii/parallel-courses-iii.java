class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] indegree = new int[n];
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] rel : relations) {
            graph.get(rel[0]-1).add(rel[1]-1);
            indegree[rel[1]-1]++;
        }
        var q = new LinkedList<Integer>();
        int[] maxTime = new int[n];
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                maxTime[i] = time[i];
                q.add(i);
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans = Math.max(maxTime[node], ans);
            for(int neigh : graph.get(node)) {
                maxTime[neigh] = Math.max(maxTime[neigh], maxTime[node] + time[neigh]);
                if(--indegree[neigh] == 0) q.add(neigh);
            }
        }
        return ans;
    }
}