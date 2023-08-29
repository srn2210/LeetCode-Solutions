class Solution {
    public int bestClosingTime(String customers) {
        int[] pref = new int[customers.length()+1];
        for(int i=0; i<customers.length(); i++) {
            pref[i+1] = pref[i] + (customers.charAt(i) == 'Y' ? 1 : -1);
        }
        int max = -1, ans = 0;
        for(int i=0; i<pref.length; i++) {
            if(pref[i] > max) {
                max = pref[i];
                ans = i;
            }
        }
        return ans;
    }
}