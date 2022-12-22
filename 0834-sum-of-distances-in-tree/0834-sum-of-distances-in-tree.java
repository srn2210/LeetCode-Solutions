class Solution {
    int tsize(int src, int[] arr, List<Set<Integer>> list, int[] sizes, int root) {
        if(list.get(src).size() == 0) return 0;
        int sz = 1;
        for(int i : list.get(src)) {
            if(i != root) {
                int t = tsize(i, arr, list, sizes, src);
                sz += t;
            }
        }
        return sizes[src] = sz;
    }
    void dfs(int src, int[] arr, List<Set<Integer>> list, int n, int root, int[] sizes) {
        int in = sizes[src];
        int out = n - in;
        arr[src] = arr[root] - in + out;
        for(int i : list.get(src)) {
            if(i != root) {
                dfs(i, arr, list, n, src, sizes);
            }
        }
        return;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<>();
        int[] arr = new int[n];
        int[] sizes = new int[n];
        for(int i=0; i<n; i++) list.add(new HashSet<>());
        for(int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        tsize(0, arr, list, sizes, -1);
        Queue<Integer> queue = new LinkedList<>();
        for(int l : list.get(0)) queue.offer(l);
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
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
        for(int l : list.get(0)) {
            dfs(l, arr, list, n, 0, sizes);
        }
        return arr;
    }
}