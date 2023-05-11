class Solution {
    void dfs(List<List<Integer>> rooms, int src, Set<Integer> set) {
        set.add(src);
        if(rooms.get(src).isEmpty()) return;
        for(int nodes : rooms.get(src)) {
            if(!set.contains(nodes)) dfs(rooms, nodes, set);
        }
        return;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var set = new HashSet<Integer>();
        dfs(rooms, 0, set);
        return set.size() == rooms.size();
    }
}