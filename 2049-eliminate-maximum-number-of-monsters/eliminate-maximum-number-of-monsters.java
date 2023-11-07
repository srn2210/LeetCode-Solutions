class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for(int i=0; i<n; i++) {
            time[i] = (int)Math.ceil(dist[i]/(double)speed[i]);
        }
        Arrays.sort(time);
        int count = 0;
        for(int i=0; i<n; i++) {
            if(count < time[i]) count++;
            else return count;
        }
        return count;
    }
}