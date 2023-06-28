class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probs = new double[n];
        probs[start] = 1.0;
        for(int j=0; j<n-1; j++) {
            var flag = false;
            for(int i=0; i<edges.length; i++) {
                int[] edge = edges[i];
                int src = edge[0];
                int des = edge[1];
                if(probs[des] * succProb[i] > probs[src]) {
                    probs[src] = probs[des] * succProb[i];
                    flag = true;
                }
                if(probs[src] * succProb[i] > probs[des]) {
                    probs[des] = probs[src] * succProb[i];
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return probs[end];
    }
}