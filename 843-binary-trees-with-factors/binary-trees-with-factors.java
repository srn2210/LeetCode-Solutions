class Solution {
    int mod = (int)1e9+7;
    Map<Integer, Integer> dp;
    int solve(int[] arr, Map<Integer, Integer> map, int val) {
        if(dp.containsKey(val)) return dp.get(val);
        long ans = 1;
        for(int i=0; i<arr.length; i++) {
            if(val % arr[i] == 0 && map.containsKey(val/arr[i])) {
                ans += (((long)solve(arr, map, arr[i]) * solve(arr, map, val/arr[i])) % mod);
                ans %= mod;
            }
        }
        dp.put(val, (int)ans);
        return (int)ans;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        dp = new HashMap<Integer, Integer>();
        // for(int i=0; i<arr.length; i++) {
        //     int counter = 0;
        //     for(int j=0; j<arr.length; j++) {
        //         if(arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) counter++;
        //     }
        //     if(counter == 0) dp.put(arr[i], 1);
        // }
        long ans = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            ans += solve(arr, map, arr[i]);
            ans %= mod;
        }
        return (int)ans;
    }
}