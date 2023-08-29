class Solution {
    /*boolean safe(int cand, String cust) {
        int penalty = 0;
        for(int i=0; i<=cand; i++) {
            if(cust.charAt(i) == 'N') penalty++;
        }
        for(int i=cand+1; i<cust.length(); i++) {
            if(cust.charAt(i) == 'Y') penalty++;
        }
        return penalty
    }*/
    public int bestClosingTime(String customers) {
        /*int left = 0, right = customers.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(safe(mid, customers)) right = mid;
            else left = mid + 1;
        }
        return left;*/
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