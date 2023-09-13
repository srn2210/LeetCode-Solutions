class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1) return 1;
        int[] arr = new int[n];
        int cnt = 2;
        for(int i=1; i<n; i++) {
            if(ratings[i-1] < ratings[i]) {
                arr[i] = cnt++;
            }
            else {
                cnt = 1;
                arr[i] = cnt++;
            }
        }
        int sum = arr[n-1];
        cnt = 2;
        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                arr[i] = Math.max(arr[i], cnt++);
            }
            else {
                cnt = 1;
                arr[i] = Math.max(arr[i], cnt++);
            }
            sum += arr[i];
        }
        return sum;
    }
}