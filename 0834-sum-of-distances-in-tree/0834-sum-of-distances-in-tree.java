class Solution {
    int tsize(int src, int[] arr, List<List<Integer>> list, List<List<Integer>> size, Set<Integer> set) {
        if(set.contains(src)) return -1;
        if(list.get(src).size() == 0) {
            size.get(src).add(0);
            return 0;
        }
        set.add(src);
        int sz = 0;
        for(int i=0; i<list.get(src).size(); i++) {
            int t = 1 + tsize(list.get(src).get(i), arr, list, size, set);
            sz += t;
            size.get(src).add(t);
        }
        size.get(src).add(sz);
        return sz;
    }
    void dfs(int src, int[] arr, List<List<Integer>> list, List<List<Integer>> size, int n, int root, Set<Integer> set) {
        /*if(list.get(src).size() == 0) {
            int out = n - size.get(src).get(size.get(src).size() - 1);
            int in = size.get(src).get(size.get(src).size() - 1);
            return;
        }*/
        //int out = size.get(root).get(size.get(root).size()-1) - size.get(src).get(size.get(src).size()-1);
        if(set.contains(src)) return;
        set.add(src);
        int in = size.get(src).get(size.get(src).size() - 1) + 1;
        int out = n - in;
        arr[src] = arr[root] - in + out;
        for(int i=0; i<list.get(src).size(); i++) {
            dfs(list.get(src).get(i), arr, list, size, n, src, set);
        }
        return;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> size = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
            size.add(new ArrayList<>());
            //set.add(i);
        }
        for(int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            //set.remove(edge[1]);
        }
        int root = 0;
        tsize(root, arr, list, size, set);
        set.clear();
        //System.out.println(size);
        Queue<Integer> queue = new LinkedList<>();
        for(int l : list.get(root)) queue.offer(l);
        int cnt = 1;
        set.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            arr[root] += len * cnt;
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
        set.add(root);
        for(int l : list.get(root)) {
            dfs(l, arr, list, size, n, root, set);
        }
        //System.out.println(arr[root]);
        return arr;
    }
}