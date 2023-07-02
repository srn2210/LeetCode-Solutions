class Solution {
    int solve(int[][] requests, int[] arr, int idx) {
        if(idx == requests.length) {
            for(int i : arr) {
                if(i != 0) return -100;
            }
            return 0;
        }
        int ans = solve(requests, arr, idx+1);
        arr[requests[idx][0]]--;
        arr[requests[idx][1]]++;
        ans = Math.max(ans, 1 + solve(requests, arr, idx+1));
        arr[requests[idx][0]]++;
        arr[requests[idx][1]]--;
        return ans;
    }
    public int maximumRequests(int n, int[][] requests) {
        return solve(requests, new int[n], 0);
    }
}