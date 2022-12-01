class Solution {
    void backtrack(int curr, List<List<Integer>> res, int j, List<Integer> temp, int[] arr, int target) {
        if(curr > target) return;
        else if(curr == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        else {
            for(int i=j; i<arr.length; i++) {
                curr += arr[i];
                temp.add(arr[i]);
                backtrack(curr, res, i, temp, arr, target);
                curr -= arr[i];
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int curr = 0;
        backtrack(curr, res, 0, new ArrayList<>(), candidates, target);
        return res;
    }
}