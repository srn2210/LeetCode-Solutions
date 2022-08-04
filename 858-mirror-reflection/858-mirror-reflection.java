class Solution {
    public int mirrorReflection(int p, int q) {
        int m = q;
        int n = p;
        
        while( m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }
        
        
        if(m % 2 != 0 && n % 2 == 0) {
            return 2;
        }
        else if (m % 2 == 0 && n % 2 != 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
}