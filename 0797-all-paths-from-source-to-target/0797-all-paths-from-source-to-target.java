class Solution {
    void dfs(int src, int[][] graph, List<Integer> list, List<List<Integer>> path, int dest) {
        if(src == dest) {
            path.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int node : graph[src]) {
                list.add(node);
                dfs(node, graph, list, path, dest);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(List.of(0));
        dfs(0, graph, list, res, graph.length-1);
        return res;
    }
}