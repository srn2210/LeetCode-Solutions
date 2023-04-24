class Solution {
    void solve(Set<Long> dp, long num, TreeSet<Long> set) {
        if(num > Integer.MAX_VALUE) return;
        if(dp.contains(num)) return;
        set.add(num);
        solve(dp, num * 2, set);
        dp.add(num * 2);
        solve(dp, num * 3, set);
        dp.add(num * 3);
        solve(dp, num * 5, set);
        dp.add(num * 5);
    }
    public int nthUglyNumber(int n) {
        var set = new TreeSet<Long>();
        solve(new HashSet<Long>(), 1, set);
        while(n-- > 1) set.remove(set.first());
        long t = set.first();
        return (int)t;
    }
}