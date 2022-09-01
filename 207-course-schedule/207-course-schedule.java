class Solution {
    boolean util(List<List<Integer>> adj, int vertex, int[] visited) {
        visited[vertex] = 1;
        
        List<Integer> list = adj.get(vertex);
        
        if(list == null || list.size() == 0) {
            visited[vertex] = 2;
            return true;
        }
        
        for(int i:list) {
            if(visited[i] == 1) return false;
            if(visited[i] == 0) {
                if(!util(adj, i, visited)) return false;
            }
        }
        
        visited[vertex] = 2;
        
        return true;        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList();
        
        for(int i=0; i<numCourses; i++) {
            list.add(new ArrayList());
        }
        
        for(int i=0; i<prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);            
        }
        
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            if(!util(list, i, visited)) return false;
        }        
        
        return true;
    }
}