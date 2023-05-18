class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var set = new boolean[n];
        for(var edge : edges) {
            set[edge.get(1)] = true;
        }
        var ans = new ArrayList<Integer>();
        for(int i=0; i<n; i++) if(!set[i]) ans.add(i);
        return ans;
    }
}