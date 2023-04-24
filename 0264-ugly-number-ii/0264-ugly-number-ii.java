class Solution {
    void solve(Set<Integer> dp, long nu, PriorityQueue<Integer> set) {
        if(nu > Integer.MAX_VALUE) return;
        int num = (int) nu;
        if(dp.contains(num)) return;
        dp.add(num);
        set.add(num);
        solve(dp, nu * 2, set);
        solve(dp, nu * 3, set);
        solve(dp, nu * 5, set);
    }
    public int nthUglyNumber(int n) {
        var set = new PriorityQueue<Integer>();
        solve(new HashSet<Integer>(), 1, set);
        while(n-- > 1) set.poll();
        return set.poll();
    }
}