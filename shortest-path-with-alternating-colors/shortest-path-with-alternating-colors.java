class Solution {
    // 0 -> red, 1 -> blue
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        int max = Integer.MAX_VALUE;
        Arrays.fill(ans, max);
        ans[0] = 0;
        var map = new HashMap<Integer, Pair<List<Integer>, List<Integer>>>();
        for(int[] red : redEdges) {
            map.computeIfAbsent(red[0], a -> new Pair<>(new ArrayList<>(), new ArrayList<>())).getKey().add(red[1]);
        }
        for(int[] blue : blueEdges) {
            map.computeIfAbsent(blue[0], a -> new Pair<>(new ArrayList<>(), new ArrayList<>())).getValue().add(blue[1]);
        }
        var q = new LinkedList<Pair<Integer, Integer>>();
        q.add(new Pair(0, 0));
        q.add(new Pair(0, 1));
        var visR = new HashSet<Pair<Integer, Integer>>();
        var visB = new HashSet<Pair<Integer, Integer>>();
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            while(size-- > 0) {
                var t = q.poll();
                int node = t.getKey();
                int col = t.getValue();
                switch(col) {
                    case 0:
                        if(!map.containsKey(node)) continue;
                        for(int neigh : map.get(node).getValue()) {
                            var p = new Pair(node, neigh);
                            if(!visB.contains(p)) {
                                visB.add(p);
                                q.add(new Pair(neigh, 1));
                                ans[neigh] = Math.min(ans[neigh], level);
                            }
                        }
                        break;
                    case 1:
                        if(!map.containsKey(node)) continue;
                        for(int neigh : map.get(node).getKey()) {
                            var p = new Pair(node, neigh);
                            if(!visR.contains(p)) {
                                visR.add(p);
                                q.add(new Pair(neigh, 0));
                                ans[neigh] = Math.min(ans[neigh], level);
                            }
                        }
                        break;
                }
            }
        }
        for(int i=0; i<n; i++) if(ans[i] == max) ans[i] = -1;
        return ans;
    }
}