class DataStream {
    int val;
    int k;
    int cnt;
    int ans;
    Queue<Integer> q;
    public DataStream(int value, int k) {
        q = new LinkedList<>();
        ans = 0;
        cnt = 0;
        val = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if(q.size() == k) {
            ans -= q.poll();
        }
        if(num == val) {
            ans += 1;
            q.add(1);
        }
        if(num != val) {
            q.add(0);
        }
        cnt++;
        if(cnt >= k && ans == k) return true;
        else return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */