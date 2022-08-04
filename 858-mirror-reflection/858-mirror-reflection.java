class Solution {
    int gcd(int p, int q) {
        if(p == 0) return q;
        else if(q == 0) return p;
        if(p == q) return p;
        if(p > q) return gcd(p-q,q);
        else return gcd(q-p, p);
    }
    public int mirrorReflection(int p, int q) {
        /*int m = q;
        int n = p;
        
        while(m % 2 == 0 && n % 2 == 0) {
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
        }*/
        
        //int res = 0;
        
        int gcd = gcd(p,q);
        
        int x = (p / gcd) % 2;
        
        int y = (q / gcd) % 2;
        
        if(x == 0) return 2;
        
        else if(y == 0) return 0;
        
        else return 1;
    }
}