class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[n];
        for(int[] i : arr) {
            int t = Arrays.binarySearch(arr, new int[]{i[1], 0}, Comparator.comparingInt((int[] a) -> a[0]));
            if(t < 0) t = -t-1;
            if(t >= intervals.length) ans[i[2]] = -1;
            else ans[i[2]] = arr[t][2];
        }
        return ans;
    }
}