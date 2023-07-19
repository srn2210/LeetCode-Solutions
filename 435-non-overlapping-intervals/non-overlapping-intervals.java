class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < end) {
                ans++;
                end = Math.min(end, intervals[i][1]);
            }
            else end = intervals[i][1];
        }
        return ans;
    }
}