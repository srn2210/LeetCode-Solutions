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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, list, res, graph.length-1);
        return res;
    }
}