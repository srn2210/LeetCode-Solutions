class Solution {
    public int minReorder(int n, int[][] connections) {
        var map = new ArrayList<List<List<Integer>>>();
        for(int i=0; i<n; i++) {
            map.add(new ArrayList<>());
        }
        for(var conn : connections) {
            map.get(conn[0]).add(List.of(conn[1], 0));
            map.get(conn[1]).add(List.of(conn[0], 1));
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
                    queue.add(l.get(0));
                }
            }
        }
        return ans;
    }
}