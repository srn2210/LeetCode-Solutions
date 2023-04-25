class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int curr;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        curr = 1;
    }
    
    public int popSmallest() {
        if(!set.isEmpty()) return set.pollFirst();
        else {
            int ans = curr;
            curr++;
            return ans;
        }
    }
    
    public void addBack(int num) {
        if(curr <= num) return;
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */