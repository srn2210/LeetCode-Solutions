class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int ans = 0;
        for(long i=2; i<n; i++) {
            if(!arr[(int)i]) {
                ans++;
                for(long j=i*i; j<n; j+=i) {
                    arr[(int)j] = true;
                }
            }
        }
        return ans;
    }
}