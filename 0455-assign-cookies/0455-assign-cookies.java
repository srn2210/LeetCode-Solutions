class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length-1;
        int j = s.length-1;
        int count = 0;
        while(i >= 0 && j >= 0) {
            if(g[i] <= s[j]) {
                count++;
                i--;
                j--;
            }
            else if(g[i] > s[j]) {
                i--;
            }
        }
        return count;
    }
}