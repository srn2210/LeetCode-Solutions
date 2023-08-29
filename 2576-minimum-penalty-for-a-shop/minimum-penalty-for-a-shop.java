class Solution {
    public int bestClosingTime(String customers) {
        int prev = 0, max = 0, ans = 0;
        for(int i=0; i<customers.length(); i++) {
            prev = prev + (customers.charAt(i) == 'Y' ? 1 : -1);
            if(prev > max) {
                max = prev;
                ans = i+1;
            }
        }
        return ans;
    }
}