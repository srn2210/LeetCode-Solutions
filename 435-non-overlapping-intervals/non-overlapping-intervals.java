class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < end) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            }
            else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return ans;
    }
}