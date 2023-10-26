class Solution {
    int mod = (int)1e9+7;
    Map<Integer, Integer> dp;
    int solve(int[] arr, Set<Integer> map, int val) {
        if(dp.containsKey(val)) return dp.get(val);
        long ans = 1;
        for(int i=0; i<arr.length; i++) {
            if(val % arr[i] == 0 && map.contains(val/arr[i])) {
                ans += (((long)solve(arr, map, arr[i]) * solve(arr, map, val/arr[i])) % mod);
                ans %= mod;
            }
        }
        dp.put(val, (int)ans);
        return (int)ans;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        var map = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++) map.add(arr[i]);
        dp = new HashMap<Integer, Integer>();
        long ans = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            ans += solve(arr, map, arr[i]);
            ans %= mod;
        }
        return (int)ans;
    }
}