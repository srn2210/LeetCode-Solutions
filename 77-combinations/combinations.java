class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        for(int j=0; j<(1 << n); j++) {
            if(Integer.bitCount(j) != k) continue;
            var ans = new ArrayList<Integer>();
            for(int i=0; i<n; i++) {
                if((j & (1 << i)) > 0) {
                    ans.add(i+1);
                }
            }
            res.add(ans);
        }
        return res;
    }
}