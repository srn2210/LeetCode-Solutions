class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        int ans = 0;
        for(long i=2; i<n; i++) {
            if(arr[(int)i] == 0) {
                ans++;
                for(long j=i*i; j<n; j+=i) {
                    arr[(int)j] = 1;
                }
            }
        }
        return ans;
    }
}