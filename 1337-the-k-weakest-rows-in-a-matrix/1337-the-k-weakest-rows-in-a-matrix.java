class Solution {
    int binarySearch(int[] arr) {
        int lo = 0;
        int hi = arr.length;
        int mid = 0;
        while(lo < hi) {
            mid = lo + ((hi-lo)/2);
            if(arr[mid] == 0) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int idx = 0;
        for(int[] i:mat) {
            int count = binarySearch(i);
            pq.add(new int[]{count, idx});
            idx++;
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.poll()[1];
        }
        return res;
    }
}