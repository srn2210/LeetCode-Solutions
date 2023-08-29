class Solution {
    public int bestClosingTime(String customers) {
        int[] pref = new int[customers.length()+1];
        int max = 0, ans = 0;
        for(int i=0; i<customers.length(); i++) {
            pref[i+1] = pref[i] + (customers.charAt(i) == 'Y' ? 1 : -1);
            if(pref[i+1] > max) {
                max = pref[i+1];
                ans = i+1;
            }
        }
        return ans;
    }
}