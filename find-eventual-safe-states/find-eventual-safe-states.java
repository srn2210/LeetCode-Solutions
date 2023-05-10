class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        var list = new ArrayList<Set<Integer>>();
        var rlist = new ArrayList<Set<Integer>>();
        var queue = new LinkedList<Integer>();
        for(int i=0; i<n; i++) {
            list.add(new HashSet<>());
            rlist.add(new HashSet<>());
        }
        for(int i=0; i<n; i++) {
            if(graph[i].length == 0) queue.add(i);
            for(int j=0; j<graph[i].length; j++) {
                rlist.get(graph[i][j]).add(i);
                list.get(i).add(graph[i][j]);
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int edge : rlist.get(x)) {
                list.get(edge).remove(x);
                if(list.get(edge).isEmpty()) queue.add(edge);
            }
        }
        var ans = new ArrayList<Integer>();
        for(int i=0; i<n; i++) if(list.get(i).isEmpty()) ans.add(i);
        return ans;
    }
}