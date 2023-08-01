class Solution {
    List<List<Integer>> res;
    boolean[] vis;
    void solve(int n, int k, int mask) {
        if(k == 0) {
            var ans = new ArrayList<Integer>();
            for(int i=0; i<n; i++) {
                if((mask & (1 << i)) > 0) {
                    ans.add(i+1);
                }
            }
            res.add(ans);
            return;
        }
        else {
            for(int i=0; i<n; i++) {
                if((mask & (1 << i)) == 0 && !vis[(mask | (1 << i))]) {
                    vis[(mask | (1 << i))] = true;
                    solve(n, k-1, mask | (1 << i));
                }
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        vis = new boolean[(1 << n)];
        solve(n, k, 0);
        return res;
    }
}