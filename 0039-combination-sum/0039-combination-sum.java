class Solution {
    void backtrack(int curr, List<List<Integer>> res, int j, Stack<Integer> temp, int[] arr, int target) {
        if(curr > target) return;
        if(curr == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(curr < target) {
            for(int i=j; i<arr.length; i++) {
                if(curr + arr[i] > target) return;
                curr += arr[i];
                temp.push(arr[i]);
                backtrack(curr, res, i, temp, arr, target);
                curr -= arr[i];
                temp.pop();
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int curr = 0;
        backtrack(curr, res, 0, new Stack<>(), candidates, target);
        return res;
    }
}