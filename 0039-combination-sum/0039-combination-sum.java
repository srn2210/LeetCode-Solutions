class Solution {
    void backtrack(int curr, Set<List<Integer>> res, int j, List<Integer> temp, int[] arr, int target) {
        if(curr > target) return;
        if(curr == target) {
            res.add(new ArrayList<>(temp));
            //System.out.println(res);
            //curr -= temp.get(temp.size()-1);
            //temp.remove(temp.size()-1);
        }
        if(curr < target) {
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
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int curr = 0;
        for(int i=0; i<candidates.length; i++) {
            //curr = candidates[i];
            backtrack(curr, res, i, temp, candidates, target);
        }
        return new ArrayList<>(res);
    }
}