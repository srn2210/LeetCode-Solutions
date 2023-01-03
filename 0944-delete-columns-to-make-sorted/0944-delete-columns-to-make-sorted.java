class Solution {
    public int minDeletionSize(String[] strs) {        
        int ans = 0;
        for(int i=0; i<strs[0].length(); i++) {
            char prev = 'a';
            for(int j=0; j<strs.length; j++) {
                if(strs[j].charAt(i) < prev) {
                    ans++;
                    break;
                }
                prev = strs[j].charAt(i);
            }
        }
        return ans;
    }
}