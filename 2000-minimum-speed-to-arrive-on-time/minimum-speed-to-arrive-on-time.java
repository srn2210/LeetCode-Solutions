class Solution {
    boolean safe(int speed, int[] dist, double hour) {
        double time = 0;
        for(int i=0; i<dist.length; i++) {
            double t = dist[i] / (double) speed;
            if(i != dist.length-1) t = Math.ceil(t);
            time += t;
        }
        return time <= hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int max = (int)(1e7+1), left = 1, right = max;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(safe(mid, dist, hour)) right = mid;
            else left = mid + 1;
        }
        return left == max ? -1 : left;
    }
}