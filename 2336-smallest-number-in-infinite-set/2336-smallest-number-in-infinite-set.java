class SmallestInfiniteSet {
    Queue<Integer> pq;
    boolean[] set;
    public SmallestInfiniteSet() {
        set = new boolean[1001];
        pq = new PriorityQueue<>();
        for(int i=1; i<=1000; i++) {
            set[i] = true;
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        set[pq.peek()] = false;
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(!set[num]) {
            set[num] = true;
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */