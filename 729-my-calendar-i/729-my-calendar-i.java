class MyCalendar {
    Set<List<Integer>> set;
    public MyCalendar() {
        set = new LinkedHashSet();
    }
    
    public boolean book(int start, int end) {
        if(set == null) {
            List<Integer> temp = new ArrayList();
            temp.add(start);
            temp.add(end);
            set.add(temp);
            return true;
        }
        for(List<Integer> entry: set) {
            if( (start >= (int)entry.get(0) && start < (int)entry.get(1)) || (end > (int)entry.get(0) && end <= (int)entry.get(1)) || (start <= (int)entry.get(0) && end >= (int)entry.get(1))) return false;
        }
        List<Integer> set1 = new ArrayList();
        set1.add(start);
        set1.add(end);
        set.add(set1);
        return true;
    }
}