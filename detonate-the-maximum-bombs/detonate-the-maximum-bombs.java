class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        var adj = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            double distance = (double)bombs[i][2];
            var list = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                if(distance >= Math.sqrt(Math.pow(bombs[i][0]-bombs[j][0],2) + Math.pow(bombs[i][1]-bombs[j][1],2))) list.add(j);
            }
            adj.add(list);
        }
        var vis = new boolean[n][n];
        var q = new LinkedList<int[]>();
        var numArr = new int[n];
        for(int i=0; i<n; i++) {
            q.add(new int[]{i,i});
            vis[i][i] = true;
        }
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var arr = q.poll();
                int node = arr[1];
                int row = arr[0];
                numArr[row]++;
                ans = Math.max(ans, numArr[row]);
                for(int neigh : adj.get(node)) {
                    if(!vis[row][neigh]) {
                        vis[row][neigh] = true;
                        q.add(new int[]{row, neigh});
                    }
                }
            }
        }
        return ans;
    }
}