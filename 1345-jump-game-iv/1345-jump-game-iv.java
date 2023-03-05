class Solution {
    public int minJumps(int[] arr) {
        var adj = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<arr.length; i++) {
            adj.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
        }
        var q = new LinkedList<Integer>();
        q.add(0);
        int ans = 0;
        var vis = new HashSet<Integer>();
        while(!q.isEmpty()) {
            var l = new LinkedList<Integer>();
            for(int node : q) {
                if(node == arr.length-1) return ans;
                
                for(int child : adj.get(arr[node])) {
                    if(!vis.contains(child)) {
                        vis.add(child);
                        l.add(child);
                    }
                }
                adj.get(arr[node]).clear();
                
                if(node + 1 < arr.length && !vis.contains(node+1)) {
                    vis.add(node+1);
                    l.add(node+1);
                }
                
                if(node - 1 >= 0 && !vis.contains(node-1)) {
                    vis.add(node-1);
                    l.add(node-1);
                }
            }
            q = l;
            ans++;
        }
        return -1;
    }
}