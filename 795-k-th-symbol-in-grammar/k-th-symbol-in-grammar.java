class Solution {
    void solve(int n, int k, Stack<String> st) {
        if(n == 0) return;
        if(k % 2 == 0) st.push("right");
        else st.push("left");
        solve(n-1, (int)Math.ceil(k/2.0), st);
    }
    public int kthGrammar(int n, int k) {
        var st = new Stack<String>();
        solve(n, k, st);
        int ans = 0;
        while(!st.isEmpty()) {
            var dir = st.pop();
            if(dir.equals("right")) ans ^= 1;
        }
        return ans;
    }
}