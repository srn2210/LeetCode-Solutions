class MedianFinder {
    int size;
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    public MedianFinder() {
        size = 0;
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(size == 0) lo.add(num);
        else if(size == 1) {
            if(num >= lo.peek()) hi.add(num);
            else {
                hi.add(lo.poll());
                lo.add(num);
            }
        }
        else if(size % 2 == 0) {
            if(!hi.isEmpty() && num > hi.peek()) {
                lo.add(hi.poll());
                hi.add(num);
            }
            else {
                lo.add(num);
            }
        }
        else {
            if(!hi.isEmpty() && num >= lo.peek()) hi.add(num);
            else {
                hi.add(lo.poll());
                lo.add(num);
            }
        }
        size++;
    }
    
    public double findMedian() {
        if(size % 2 != 0) return (double)lo.peek();
        else {
            return (lo.peek() + hi.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */