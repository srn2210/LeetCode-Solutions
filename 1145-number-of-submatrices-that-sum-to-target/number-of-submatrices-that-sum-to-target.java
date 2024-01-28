class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefix = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int prevRow = i-1 >= 0 ? prefix[i-1][j] : 0;
                int prevCol = j-1 >= 0 ? prefix[i][j-1] : 0;
                int prevDiag = i-1 >= 0 && j-1 >= 0 ? prefix[i-1][j-1] : 0;
                prefix[i][j] = prevRow + prevCol - prevDiag + matrix[i][j];
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=i; j<m; j++) {
                var map = new HashMap<Integer, Queue<Integer>>();
                for(int k=0; k<n; k++) {
                    int prevRow = i-1 >= 0 ? prefix[i-1][k] : 0;
                    int sum = prefix[j][k] - prevRow;
                    map.computeIfAbsent(sum, a -> new LinkedList<Integer>()).add(k);
                    if(sum == target) ans++;
                    // System.out.println("Top Row - (" + i + ",0) and Bottom - (" + j + "," + k + ") = " + sum);
                }
                for(int k=0; k<n-1; k++) {
                    int prevRow = i-1 >= 0 ? prefix[i-1][k] : 0;
                    int sum = prefix[j][k] - prevRow;
                    if(map.containsKey(target+sum)) {
                        while(!map.get(target+sum).isEmpty() && map.get(target+sum).peek() <= k) {
                            map.get(target+sum).poll();
                        }
                        ans += map.get(target+sum).size();
                    }
                }
            }
        }
        return ans;
    }
}