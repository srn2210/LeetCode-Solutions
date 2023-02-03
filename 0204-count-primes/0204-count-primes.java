class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        if(n < 3) return 0;
        int ans = 1;
        for(long i=3; i<n; i+=2) {
            if(!arr[(int)i]) {
                ans++;
                for(long j=i*i; j<n; j+=2*i)
                    arr[(int)j] = true;
            }
        }
        return ans;
    }
}