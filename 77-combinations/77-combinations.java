class Solution {
    void backtrack(List<List<Integer>> list, int n, int k, Stack<Integer> arr, int start) {
        int size = arr.size();
        if(size == k) {
            list.add(new ArrayList(arr));
        }
        else {
            for(int i=start; i<=n; i++) {
                arr.push(i);
                backtrack(list, n, k, arr, i+1);
                arr.pop();
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, n, k, new Stack(), 1);
        return list;
    }
}