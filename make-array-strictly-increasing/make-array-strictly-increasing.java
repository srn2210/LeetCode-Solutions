class Solution {
    Map<Pair<Integer, Integer>, Integer> dp;
    int solve(int[] arr, TreeMap<Integer, Integer> map, int idx, int prev) {
        if(idx == arr.length) return 0;
        if(dp.containsKey(new Pair<>(idx, prev))) return dp.get(new Pair<>(idx, prev));
        int ans = 100000;
        var low = map.higherKey(prev);
        if(arr[idx] > prev) ans = solve(arr, map, idx+1, arr[idx]);
        if(low != null) ans = Math.min(ans, 1 + solve(arr, map, idx+1, low));
        dp.put(new Pair<>(idx, prev), ans);
        return ans;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        var map = new TreeMap<Integer, Integer>();
        for(int i : arr2) map.put(i, map.getOrDefault(i, 0)+1);
        dp = new HashMap<>();
        int ans = solve(arr1, map, 0, -1);
        return ans >= 100000 ? -1 : ans;
    }
}