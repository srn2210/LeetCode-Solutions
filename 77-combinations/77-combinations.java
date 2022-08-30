class Solution {
    void backtrack(List<List<Integer>> list, int n, int k, Deque<Integer> arr, int start) {
        int size = arr.size();
        if(size == k) {
            list.add(new ArrayList(arr));
        }
        else {
            for(int i=start; i<=n-k+size+1; i++) {
                arr.offer(i);
                backtrack(list, n, k, arr, i+1);
                arr.removeLast();
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, n, k, new ArrayDeque(), 1);
        return list;
    }
}