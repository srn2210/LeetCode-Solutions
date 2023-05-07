class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int ans = 0;
        int[] res = new int[queries.length];
        int[] arr = new int[n];
        for(int i=0; i<queries.length; i++) {
            int idx = queries[i][0];
            int col = queries[i][1];
            if(idx > 0 && arr[idx] == arr[idx-1] && arr[idx] != 0) ans -= 1;
            if(idx < n-1 && arr[idx] == arr[idx+1] && arr[idx] != 0) ans -= 1;
            arr[idx] = col;
            if(idx > 0 && arr[idx] == arr[idx-1] && arr[idx] != 0) ans += 1;
            if(idx < n-1 && arr[idx] == arr[idx+1] && arr[idx] != 0) ans += 1;
            res[i] = ans;
        }
        return res;
    }
}