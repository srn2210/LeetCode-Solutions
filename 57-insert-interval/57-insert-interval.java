class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int x = newInterval[0];
        int y = newInterval[1];
        
        /*int xcod[] = new int[intervals.length];
        int ycod[] = new int[intervals.length];
        
        for(int i=0; i<intervals.length; i++) {
            xcod[i] = intervals[i][0];
            ycod[i] = intervals[i][1];
        }
        
        int insertx = Arrays.binarySearch(xcod, x);
        int inserty = Arrays.binarySearch(ycod, y);
        
        insertx = insertx < 0 ? (-1 * insertx) - 1 : insertx;
        inserty = inserty < 0 ? (-1 * inserty) - 1 : inserty;
        
        System.out.println(insertx);
        
        int insx = xcod[insertx] < x ? xcod[insertx] : x;
        int insy = ycod[inserty] > y ? ycod[inserty] : y;*/
        
        List<List<Integer>> list = new ArrayList();
        
        if(intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0][0] = x;
            res[0][1] = y;
            return res;
        }
        
        /*if(y < intervals[0][0]) {
            List<Integer> l = new ArrayList();
            l.add(x);
            l.add(y);
            list.add(l);
        }*/
        
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
                //continue;
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
        
        return res;        
    }
}