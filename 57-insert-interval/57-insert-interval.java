class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        
        for(int [] i:intervals) {
            if(newInterval[1] < i[0]) {
                res.add(newInterval);
                newInterval = i;
            }
            else if(i[1] < newInterval[0]) {
                res.add(i);
            }
            else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        
        res.add(newInterval);
        
        return res.toArray(new int[res.size()][2]);
    }
}