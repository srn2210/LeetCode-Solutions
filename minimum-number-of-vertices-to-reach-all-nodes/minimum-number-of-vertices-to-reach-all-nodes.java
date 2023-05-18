class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var set = new HashSet<Integer>();
        for(int i=0; i<n; i++) set.add(i);
        for(var edge : edges) {
            set.remove(edge.get(1));
        }
        return new ArrayList<>(set);
    }
}