class Solution {
    // int solve(int currN, int n, int currK, int k, int curr) {
    //     if(currN == n && currK == k) return curr;
    //     if(curr == 0) {
    //         if(k % 2 != 0) return solve(currN+1, n, (currK*2)-1, k, 0);
    //         if(k % 2 == 0) return solve(currN+1, n, currK*2, k, 1);
    //     }
    //     else {
    //         if(k % 2 != 0) return solve(currN+1, n, (currK*2)-1, k, 1);
    //         if(k % 2 == 0) return solve(currN+1, n, currK*2, k, 0);
    //     }
    //     return -1;
    // }
    void solve(int n, int k, Stack<String> st) {
        if(n == 0) return;
        if(k % 2 == 0) st.push("right");
        else st.push("left");
        solve(n-1, (int)Math.ceil(k/2.0), st);
    }
    public int kthGrammar(int n, int k) {
        // return solve(1, n, 1, k, 0);
        //return (n-1)
        var st = new Stack<String>();
        solve(n, k, st);
        // System.out.println(st);
        int ans = 0;
        while(!st.isEmpty()) {
            var dir = st.pop();
            if(dir.equals("right")) {
                if(ans == 0) ans = 1;
                else ans = 0;
            }
        }
        return ans;
    }
}