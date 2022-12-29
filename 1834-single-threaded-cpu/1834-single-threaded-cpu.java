class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1] == 0 ? a[2]-b[2] : a[1]-b[1]);
        int[][] arr = new int[tasks.length][3];
        for(int i=0; i<tasks.length; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0] == 0 ? a[1]-b[1] : a[0] - b[0]);
        int curr = arr[0][0];
        int j = 0;
        int i = 0;
        while(i < tasks.length) {
            if(arr[i][0] <= curr) {
                pq.add(arr[i]);
                i++;
            }
            else {
                while(!pq.isEmpty() && curr < arr[i][0]) {
                    ans[j++] = pq.peek()[2];
                    curr += pq.peek()[1];
                    pq.poll();
                }
                if(curr < arr[i][0]) curr = arr[i][0];
            }
        }
        while(!pq.isEmpty()) {
            ans[j++] = pq.poll()[2];
        }
        return ans;
    }
}