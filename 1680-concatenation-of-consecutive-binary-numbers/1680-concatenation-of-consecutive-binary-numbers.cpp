class Solution {
public:
    int concatenatedBinary(int n) {
        int bits = 0;
        long long ans = 0;
        for(int i=1; i<=n; i++) {
            if(!(i & i-1))
                bits++;
            ans = ((ans << bits) | i) % 1000000007;
        }
        return (int) ans;
    }
};