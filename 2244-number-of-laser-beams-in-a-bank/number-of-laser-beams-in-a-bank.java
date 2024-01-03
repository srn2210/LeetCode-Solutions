class Solution {
    public int numberOfBeams(String[] bank) {
        int prevCount = 0, n = bank.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<bank[i].length(); j++) {
                if(bank[i].charAt(j) == '1') count++;
            }
            ans += count * prevCount;
            if(count != 0) prevCount = count;
        }
        return ans;
    }
}