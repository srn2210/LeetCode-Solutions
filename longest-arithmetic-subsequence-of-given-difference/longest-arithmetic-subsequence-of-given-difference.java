class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        var dp = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            dp.put(arr[i], 1 + dp.getOrDefault(arr[i] - difference, 0));
            ans = Math.max(dp.get(arr[i]), ans);
        }
        return ans;
    }
}