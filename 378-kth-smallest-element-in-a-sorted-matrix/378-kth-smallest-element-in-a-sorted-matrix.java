class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length * matrix.length];
        int count = 0;
        for(int[] i:matrix) {
            for(int j:i) {
                arr[count] = j;
                count++;
            }
        }
        
        Arrays.sort(arr);
        
        return arr[k-1];
    }
}