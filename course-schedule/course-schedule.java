class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adj = new HashMap<Integer, List<Integer>>();
        var q = new LinkedList<Integer>();
        var indegree = new int[numCourses];
        for(int[] req : prerequisites) {
            adj.computeIfAbsent(req[1], a -> new ArrayList<>()).add(req[0]);
            indegree[req[0]]++;
        }
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            var curr = q.poll();
            if(!adj.containsKey(curr)) continue;
            for(int neigh : adj.get(curr)) if(--indegree[neigh] == 0) q.add(neigh);
        }
        for(int i : indegree) if(i != 0) return false;
        return true;
    }
}