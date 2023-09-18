class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0], a[0]) == 0 ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));
        for(int i=0; i<mat.length; i++) {
            int count = 0;
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) break;
                count++;
            }
            pq.add(new int[]{count, i});
            if(pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--) ans[i] = pq.poll()[1];
        return ans;
    }
}