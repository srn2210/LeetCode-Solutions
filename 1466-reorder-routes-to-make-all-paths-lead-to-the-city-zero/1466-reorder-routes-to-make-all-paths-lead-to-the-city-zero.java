class Solution {
    public int minReorder(int n, int[][] connections) {
        var map = new HashMap<Integer, List<List<Integer>>>();
        for(var conn : connections) {
            map.computeIfAbsent(conn[0], a -> new ArrayList<>()).add(List.of(conn[1], 0));
            map.computeIfAbsent(conn[1], a -> new ArrayList<>()).add(List.of(conn[0], 1));
        }
        int ans = 0;
        var queue = new LinkedList<Integer>();
        queue.add(0);
        var visited = new boolean[n];
        while(!queue.isEmpty()) {
            visited[queue.peek()] = true;
            var t = map.get(queue.poll());
            for(var l : t) {
                if(!visited[l.get(0)]) {
                    if(l.get(1) == 0) ans++;
                    if(!visited[l.get(0)]) queue.add(l.get(0));
                }
            }
        }
        return ans;
    }
}