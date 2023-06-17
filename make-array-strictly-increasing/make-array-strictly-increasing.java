class Solution {
    Map<Pair<Integer, Integer>, Integer> dp;
    int higher(int[] arr, int target) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    int solve(int[] arr, int[] arr2, int idx, int prev) {
        if(idx == arr.length) return 0;
        if(dp.containsKey(new Pair<>(idx, prev))) return dp.get(new Pair<>(idx, prev));
        int ans = 100000;
        var low = higher(arr2, prev);
        if(arr[idx] > prev) ans = solve(arr, arr2, idx+1, arr[idx]);
        if(low < arr2.length) ans = Math.min(ans, 1 + solve(arr, arr2, idx+1, arr2[low]));
        dp.put(new Pair<>(idx, prev), ans);
        return ans;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        dp = new HashMap<>();
        int ans = solve(arr1, arr2, 0, -1);
        return ans >= 100000 ? -1 : ans;
    }
}