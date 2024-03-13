class Solution {
    int sum(int num) {
        return (num * (num+1)) / 2;
    }
    public int pivotInteger(int n) {
        int total = sum(n);
        for(int i=n; i>0; i--) if(sum(i) == (total - sum(i-1))) return i;
        return -1;
    }
}