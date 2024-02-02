class Solution {
    int high;
    int low;
    void solve(int start, List<Integer> ans) {
        if(start > high) return;
        if(start >= low && start <= high) ans.add(start);
        int last = start % 10;
        if(last == 9) return;
        start = start * 10 + last + 1;
        solve(start, ans);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        this.high = high;
        this.low = low;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=1; i<=9; i++) solve(i, ans);
        Collections.sort(ans);
        return ans;
    }
}