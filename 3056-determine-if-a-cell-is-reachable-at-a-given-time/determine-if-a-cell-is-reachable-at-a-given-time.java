class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int lSteps = Math.max(Math.abs(fx-sx), Math.abs(fy-sy));
        int mSteps = Math.abs(fx-sx) + Math.abs(fy-sy);
        if(t < lSteps) return false;
        if(t - lSteps != 1) return true;
        return Math.abs(fx-sx) >= 1 || Math.abs(fy-sy) >= 1;
    }
}