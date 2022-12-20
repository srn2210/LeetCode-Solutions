class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        for(int i : rooms.get(0))
            queue.offer(i);
        vis[0] = true;
        while(!queue.isEmpty()) {
            int t = queue.poll();
            if(!vis[t]) {
                for(int i : rooms.get(t)) {
                    if(!vis[i]) queue.offer(i);
                }
            }
            vis[t] = true;
        }
        boolean ans = true;
        for(boolean b : vis) ans &= b;
        return ans;
    }
}