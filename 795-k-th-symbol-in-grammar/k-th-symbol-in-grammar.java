class Solution {
    void solve(int n, int k, Stack<Integer> st) {
        if(n == 0) return;
        if(k % 2 == 0) st.push(1);
        else st.push(0);
        solve(n-1, (int)Math.ceil(k/2.0), st);
    }
    public int kthGrammar(int n, int k) {
        var st = new Stack<Integer>();
        solve(n, k, st);
        int ans = 0;
        while(!st.isEmpty()) {
            var dir = st.pop();
            if(dir.equals(1)) ans ^= 1;
        }
        return ans;
    }
}