class Solution {
    boolean flag;
    void dfs(int grp, Map<Integer, Set<Integer>> grpDep, int[] vis, Deque<Integer> st) {
        vis[grp] = 1;
        if(!grpDep.containsKey(grp)) {
            vis[grp] = 2;
            st.addLast(grp);
            return;
        }
        for(int dep : grpDep.get(grp)) {
            if(vis[dep] == 0) {
                dfs(dep, grpDep, vis, st);
            }
            else if(vis[dep] == 1) flag = true;
        }
        vis[grp] = 2;
        st.addLast(grp);
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int gID = m;
        flag = false;
        for(int i=0; i<n; i++) {
            if(group[i] == -1) group[i] = gID++;
        }
        var grpDep = new HashMap<Integer, Set<Integer>>();
        var intDep = new HashMap<Integer, Set<Integer>>();
        var grpMap = new HashMap<Integer, Set<Integer>>();
        for(int i=0; i<n; i++) {
            if(!grpDep.containsKey(group[i])) grpDep.put(group[i], new HashSet<>());
            if(!intDep.containsKey(i)) intDep.put(i, new HashSet<>());
            if(!grpMap.containsKey(group[i])) grpMap.put(group[i], new HashSet<>());
            grpMap.get(group[i]).add(i);
            for(int neigh : beforeItems.get(i)) {
                if(group[i] == group[neigh]) {
                    intDep.get(i).add(neigh);
                }
                else {
                    grpDep.get(group[i]).add(group[neigh]);
                }
            }
        }
        m = gID;
        var st = new ArrayDeque<Integer>();
        int[] vis = new int[m];
        for(int i : grpMap.keySet()) {
            if(vis[i] == 0) {
                dfs(i, grpDep, vis, st);
            }
        }
        if(flag) return new int[0];

        var map = new HashMap<Integer, List<Integer>>();
        for(var entry : grpMap.entrySet()) {
            int grpId = entry.getKey();
            var set = entry.getValue();
            var intSt = new ArrayDeque<Integer>();
            int[] visited = new int[n];
            for(int i : set) {
                if(visited[i] == 0) {
                    dfs(i, intDep, visited, intSt);
                }
            }
            var arr = new ArrayList<Integer>();
            while(!intSt.isEmpty()) arr.add(intSt.pollFirst());
            map.put(grpId, arr);
        }
        if(flag) return new int[0];
        int[] ans = new int[n];
        int ind = 0;
        while(!st.isEmpty()) {
            int grpId = st.pollFirst();
            if(map.containsKey(grpId)) {
                for(int i : map.get(grpId)) {
                    ans[ind++] = i;
                }
            }
            else {
                for(int i : grpMap.get(grpId)) {
                    ans[ind++] = i;
                }
            }
        }
        return ans;
    }
}