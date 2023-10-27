class Solution {
    int[] pre;
    Set<String> state;
    Map<Integer, Integer> map;
    void solve(int[] arr, int target, int curr, int idx, List<Integer> list, Set<List<Integer>> ans) {
        if(curr == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx >= arr.length) return;
        state.add(map.toString());
        //System.out.println(state);
        if(curr + arr[idx] <= target) {
            list.add(arr[idx]);
            var currMap = map;
            currMap.put(arr[idx], currMap.getOrDefault(arr[idx], 0)+1);
            if(!state.contains(currMap.toString()))solve(arr, target, curr+arr[idx], idx+1, list, ans);
            currMap.put(arr[idx], currMap.getOrDefault(arr[idx], 0)-1);
            list.remove(list.size()-1);
        }
        else return;
        if(pre[idx]-arr[idx] + curr < target) {
            return;
        }
        else solve(arr, target, curr, idx+1, list, ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        state = new HashSet<>();
        pre = new int[candidates.length];
        pre[candidates.length-1] = candidates[candidates.length-1];
        for(int i=candidates.length-2; i>=0; i--) {
            pre[i] = candidates[i] + pre[i+1];
        }
        map = new HashMap<>();
        solve(candidates, target, 0, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
}