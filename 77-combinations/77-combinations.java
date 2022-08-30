class Solution {
    void backtrack(List<List<Integer>> list, int n, int k, Set<Integer> set, int start) {
        if(set.size() == k) {
            list.add(List.copyOf(set));
        }
        else {
            for(int i=start; i<=n; i++) {
                set.add(i);
                backtrack(list, n, k, set, i+1);
                set.remove(i);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, n, k, new LinkedHashSet(), 1);
        return list;
    }
}