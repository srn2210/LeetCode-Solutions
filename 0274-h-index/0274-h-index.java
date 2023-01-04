class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = citations[0] == 0 ? 0 : 1;
        int n = citations.length;
        for(int i=0; i<n; i++) {
            if(citations[i] >= n-i) ans = Math.max(ans, n-i);
        }
        return ans;
    }
}