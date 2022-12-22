class Solution {
    int tsize(int src, int[] arr, Map<Integer, Set<Integer>> list, Set<Integer> set, int[] sizes) {
        if(set.contains(src)) return -1;
        if(!list.containsKey(src) || list.get(src).size() == 0) return 0;
        set.add(src);
        int sz = 0;
        for(int i : list.get(src)) {
            int t = 1 + tsize(i, arr, list, set, sizes);
            sz += t;
        }
        sizes[src] = sz;
        return sz;
    }
    void dfs(int src, int[] arr, Map<Integer, Set<Integer>> list, int n, int root, Set<Integer> set, int[] sizes) {
        if(set.contains(src)) return;
        set.add(src);
        int in = sizes[src] + 1;
        int out = n - in;
        arr[src] = arr[root] - in + out;
        for(int i : list.get(src)) {
            dfs(i, arr, list, n, src, set, sizes);
        }
        return;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> list = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        int[] sizes = new int[n];
        for(int[] edge : edges) {
            if(!list.containsKey(edge[0])) list.put(edge[0], new HashSet<>());
            if(!list.containsKey(edge[1])) list.put(edge[1], new HashSet<>());
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        tsize(0, arr, list, set, sizes);
        set.clear();
        Queue<Integer> queue = new LinkedList<>();
        if(list.containsKey(0)) for(int l : list.get(0)) queue.offer(l);
        int cnt = 1;
        set.add(0);
        while(!queue.isEmpty()) {
            int len = queue.size();
            arr[0] += len * cnt;
            while(len-- > 0) {
                int s = queue.poll();
                set.add(s);
                for(int i : list.get(s)) {
                    if(!set.contains(i)) queue.offer(i);
                }
            }
            cnt++;
        }
        set.clear();
        set.add(0);
        if(list.containsKey(0)) {
            for(int l : list.get(0)) {
                dfs(l, arr, list, n, 0, set, sizes);
            }
        }
        return arr;
    }
}