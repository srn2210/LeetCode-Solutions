class Solution {
    void dfs(int src, int[][] graph, Set<Integer> set, List<List<Integer>> path, int dest) {
        if(src == dest) {
            //set.add(src);
            path.add(new ArrayList<>(set));
            return;
        }
        else {
            for(int i=0; i<graph[src].length; i++) {
                if(!set.contains(graph[src][i])) {
                    set.add(graph[src][i]);
                    dfs(graph[src][i], graph, set, path, dest);
                    set.remove(graph[src][i]);
                }
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<graph[0].length; i++) {
            dfs(graph[0][i], graph, new LinkedHashSet<>(List.of(0, graph[0][i])), res, graph.length-1);
        }
        return res;
    }
}