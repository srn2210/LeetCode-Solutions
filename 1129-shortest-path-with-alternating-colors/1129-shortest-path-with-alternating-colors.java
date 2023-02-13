class Solution {
    int[] bfs(boolean flag, List<List<Integer>> arr, List<List<Integer>> red, List<List<Integer>> blue, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        var queue = new LinkedList<Pair<Integer, Integer>>();
        var set1 = new HashSet<Pair<Integer, Integer>>();
        var set2 = new HashSet<Pair<Integer, Integer>>();
        for(int i : arr.get(0)) queue.offerLast(new Pair(0, i));
        int dist = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                if(flag) {
                    var t = queue.pollFirst();
                    ans[t.getValue()] = Math.min(ans[t.getValue()], dist);
                    set1.add(t);
                    for(int i : blue.get(t.getValue())) if(!set2.contains(new Pair(t.getValue(), i))) queue.add(new Pair(t.getValue(), i));
                }
                else {
                    var t = queue.pollFirst();
                    ans[t.getValue()] = Math.min(ans[t.getValue()], dist);
                    set2.add(t);
                    for(int i : red.get(t.getValue())) if(!set1.contains(new Pair(t.getValue(), i))) queue.add(new Pair(t.getValue(), i));
                }
            }
            dist++;
            flag = !flag;
        }
        return ans;
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        var red = new ArrayList<List<Integer>>();
        var blue = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            red.add(new ArrayList<Integer>());
            blue.add(new ArrayList<Integer>());
        }
        for(var r : redEdges) red.get(r[0]).add(r[1]);
        for(var b : blueEdges) blue.get(b[0]).add(b[1]);
        var ans1 = bfs(true, red, red, blue, n);
        var ans2 = bfs(false, blue, red, blue, n);
        for(int i=0; i<n; i++) {
            ans1[i] = Math.min(ans1[i], ans2[i]);
            ans1[i] = ans1[i] == Integer.MAX_VALUE ? -1 : ans1[i];
        }
        return ans1;
    }
}