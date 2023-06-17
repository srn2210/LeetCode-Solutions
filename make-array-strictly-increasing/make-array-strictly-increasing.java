class Solution {
    Map<Pair<Integer, Integer>, Integer> dp;
    int solve(int[] arr, TreeSet<Integer> map, int idx, int prev) {
        if(idx == arr.length) return 0;
        if(dp.containsKey(new Pair<>(idx, prev))) return dp.get(new Pair<>(idx, prev));
        int ans = (int)1e5;
        var low = map.higher(prev);
        if(arr[idx] > prev) ans = solve(arr, map, idx+1, arr[idx]);
        if(low != null) ans = Math.min(ans, 1 + solve(arr, map, idx+1, low));
        dp.put(new Pair<>(idx, prev), ans);
        return ans;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        var map = new TreeSet<Integer>();
        for(int i : arr2) map.add(i);
        dp = new HashMap<>();
        int ans = solve(arr1, map, 0, -1);
        return ans >= (int)1e5 ? -1 : ans;
    }
}