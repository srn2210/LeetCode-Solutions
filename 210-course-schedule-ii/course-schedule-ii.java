class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adj = new ArrayList<List<Integer>>();
        var ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        var q = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) if(indegree[i] == 0) q.add(i);
        var list = new LinkedList<Integer>();
        while(!q.isEmpty()) {
            var node = q.poll();
            list.add(node);
            for(int edge : adj.get(node)) {
                indegree[edge]--;
                if(indegree[edge] == 0) q.add(edge);
            }
        }
        if(list.size() != numCourses) return new int[0];
        else {
            for(int i=0; i<list.size(); i++) {
                ans[i] = list.get(i);
            }
        }
        return ans;
    }
}