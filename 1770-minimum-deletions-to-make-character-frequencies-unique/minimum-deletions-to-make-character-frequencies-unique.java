class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        for(char ch : s.toCharArray()) counts[ch-'a']++;
        Arrays.sort(counts);
        int ans = 0;
        for(int i=24; i>=0; i--) {
            if(counts[i] >= counts[i+1]) {
                int diff = counts[i] - counts[i+1] + (counts[i+1] == 0 ? 0 : 1);
                counts[i] -= diff;
                ans += diff;
            }
        }
        return ans;
    }
}