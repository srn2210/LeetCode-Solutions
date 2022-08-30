class Solution {
    void backtrack(List<List<Integer>> list, int n, int k, List<Integer> set, int start) {
        if(set.size() == k) {
            list.add(new ArrayList(set));
        }
        else {
            for(int i=start; i<=n-k+set.size()+1; i++) {
                set.add(i);
                backtrack(list, n, k, set, i+1);
                set.remove((Integer)i);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, n, k, new ArrayList(), 1);
        return list;
    }
}