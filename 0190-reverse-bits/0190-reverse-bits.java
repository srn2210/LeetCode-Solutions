public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int j = 0;
        int cnt = 0;
        while(n != 0) {
            cnt++;
            int temp = n & 1;
            j <<= 1;
            j |= temp;
            n >>= 1;
            if(cnt == 32) break;
            
        }
        while(cnt++ != 32) {
            j = j << 1;
        }
        return j;
    }
}