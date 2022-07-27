class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int remove=0;
        
        if(intervals.length == 1) return 0;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int min = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++){
            if(min > intervals[i][0]){
                remove++;
            }
            else min = intervals[i][1];
        }
        
        return remove;
    }
}