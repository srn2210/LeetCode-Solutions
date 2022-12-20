class Solution {
    class UnionFind {
        int[] arr;
        int[] size;
        UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }
        int find(int i) {
            if(i == arr[i]) return i;
            return arr[i] = find(arr[i]);
        }
        boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
        void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if(size[x] < size[y]) {
                arr[x] = arr[y];
                size[y] += size[x];
            }
            else {
                arr[y] = arr[x];
                size[x] += size[y];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind obj = new UnionFind(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<String>> map2 = new HashMap<>();
        for(int j=0; j<accounts.size(); j++) {
            for(int i=1; i<accounts.get(j).size(); i++) {
                if(map.containsKey(accounts.get(j).get(i))) {
                    obj.union(j, map.get(accounts.get(j).get(i)));
                }
                else {
                    map.put(accounts.get(j).get(i), obj.find(j));
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(int i : obj.arr) {
            List<String> temp = new ArrayList<>();
            //temp.add(accounts.get(i).get(0));
            map2.put(obj.find(i), temp);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            map2.get(obj.find(index)).add(entry.getKey());
        }
        for(Map.Entry<Integer, List<String>> entry : map2.entrySet()) {
            res.add(entry.getValue());
            Collections.sort(res.get(res.size()-1));
            res.get(res.size()-1).add(0, accounts.get(entry.getKey()).get(0));
        }
        return res;
    }
}