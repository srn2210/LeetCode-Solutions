class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hdp0 = horizontalCuts[0];
        int vdp0 = verticalCuts[0];
        int hdp1 = h - horizontalCuts[horizontalCuts.length-1];
        int vdp1 = w - verticalCuts[verticalCuts.length-1];
        long maxh = Math.max(hdp1, hdp0), maxv = Math.max(vdp1, vdp0);
        
        for(int i=1; i<horizontalCuts.length; i++){
            maxh = Math.max(maxh, Math.abs(horizontalCuts[i] - horizontalCuts[i-1]));
        }
        for(int i=1; i<verticalCuts.length; i++){
            maxv = Math.max(Math.abs(verticalCuts[i] - verticalCuts[i-1]), maxv);
        }
        
        long mod = Long.valueOf(1000000007);
        int ans = (int) (((maxh) * (maxv)) % mod);
        
        return ans;
        
    }
}