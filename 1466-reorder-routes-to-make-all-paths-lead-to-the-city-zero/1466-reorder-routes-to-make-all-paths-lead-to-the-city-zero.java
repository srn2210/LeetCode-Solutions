class Solution {
    public int minReorder(int n, int[][] connections) {
        var map = new ArrayList<List<int[]>>(n);
        for(int i=0; i<n; i++) {
            map.add(new ArrayList<>());
        }
        for(var conn : connections) {
            map.get(conn[0]).add(new int[]{conn[1], 0});
            map.get(conn[1]).add(new int[]{conn[0], 1});
        }
        int ans = 0;
        var queue = new ArrayDeque<Integer>();
        queue.add(0);
        var visited = new boolean[n];
        while(!queue.isEmpty()) {
            visited[queue.peek()] = true;
            var t = map.get(queue.poll());
            for(var l : t) {
                if(!visited[l[0]]) {
                    if(l[1] == 0) ans++;
                    queue.add(l[0]);
                }
            }
        }
        return ans;
    }
}