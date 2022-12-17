class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n == 0) return false;
        long a = n;
        long i = a & (-a);
        if(n - i == 0) return true;
        return false;
    }
};