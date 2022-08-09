class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*int x = newInterval[0];
        int y = newInterval[1];
        
        if(intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0][0] = x;
            res[0][1] = y;
            return res;
        }
        
        List<List<Integer>> list = new ArrayList();
        
        int temp = -1;
        boolean X = false;
        boolean Y = false;
        
        for(int[] i:intervals) {
            if(temp != -1) {
                if( y < i[0]) {
                    List<Integer> l = new ArrayList();
                    l.add(temp);
                    l.add(y);
                    list.add(l);
                    temp = -1;
                    Y = true;
                }
                else if(y == i[0]) {
                    List<Integer> l = new ArrayList();
                    l.add(temp);
                    l.add(i[1]);
                    list.add(l);
                    temp = -1;
                    Y = true;
                    continue;
                }
                else if(y > i[0] && y <= i[1]) {
                    List<Integer> l = new ArrayList();
                    l.add(temp);
                    l.add(i[1]);
                    list.add(l);
                    temp = -1;
                    Y = true;
                    continue;
                }
                else continue;
            }
            if(i[0] <= x && x <= i[1] && i[0] <= y && y <= i[1]) {
                List<Integer> l = new ArrayList();
                l.add(i[0]);
                l.add(i[1]);
                list.add(l);
                X = true;
                Y = true;
                continue;
            }
            else if(i[0] <= x && x <= i[1] && y >= i[1]) {
                temp = i[0];
                X = true;
                continue;
            }
            else if(x <= i[0] && y >= i[1]) {
                temp = x;
                X = true;
                continue;
            }
            else if(x <= i[0] && i[0] <= y && y <= i[1]) {
                List<Integer> l = new ArrayList();
                l.add(x);
                l.add(i[1]);
                list.add(l);
                X = true;
                Y = true;
                continue;
            }
            else if(!X && !Y && x < i[0] && y < i[0]) {
                List<Integer> l = new ArrayList();
                l.add(x);
                l.add(y);
                list.add(l);
                X = true;
                Y = true;
            }
            List<Integer> l = new ArrayList();
            l.add(i[0]);
            l.add(i[1]);
            list.add(l);
        }
        
        if(x > intervals[intervals.length-1][1]) {
            List<Integer> l = new ArrayList();
            l.add(x);
            l.add(y);
            list.add(l);
        }
        
        if(temp != -1) {
            List<Integer> l = new ArrayList();
            l.add(temp);
            l.add(y);
            list.add(l);
        }
        
        int[][] res = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        
        return res;*/
        
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