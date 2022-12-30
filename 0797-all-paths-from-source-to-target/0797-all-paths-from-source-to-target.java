class Solution {
    void dfs(int src, int[][] graph, List<Integer> list, List<List<Integer>> path, int dest) {
        if(src == dest) {
            path.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int i=0; i<graph[src].length; i++) {
                list.add(graph[src][i]);
                dfs(graph[src][i], graph, list, path, dest);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<graph[0].length; i++) {
            dfs(graph[0][i], graph, new ArrayList<>(List.of(0, graph[0][i])), res, graph.length-1);
        }
        return res;
    }
}