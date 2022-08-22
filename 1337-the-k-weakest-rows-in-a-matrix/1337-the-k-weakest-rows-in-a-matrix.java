class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][2];
        int idx = 0;
        for(int[] i:mat) {
            int count = 0;
            for(int j:i) {
                if(j == 1) {
                    count++;
                }
            }
            arr[idx][0] = count;
            arr[idx][1] = idx;
            idx++;
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = arr[i][1];
        }
        return res;
    }
}