class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int start = 0;
        int prevMon = 0, prevDay = 0;
        while(start < n) {
            if(start % 7 == 0) {
                ans += ++prevMon;
                prevDay = prevMon;
            }
            else {
                ans += ++prevDay;
            }
            start++;
        }
        return ans;
    }
}