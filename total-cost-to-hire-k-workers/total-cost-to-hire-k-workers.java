class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length, left = 0, right = n-1;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i] = new int[]{costs[i], i};
        }
        var pqLeft = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        var pqRight = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for(int i=0; i<candidates; i++) {
            if(left <= right) pqLeft.add(arr[left++]);
            if(right >= left) pqRight.add(arr[right--]);
        }
        long ans = 0;
        for(int i=0; i<k; i++) {
            int curr = 0;
            if(!pqLeft.isEmpty() && !pqRight.isEmpty() && pqLeft.peek()[0] < pqRight.peek()[0]) {
                curr = pqLeft.poll()[0];
                if(left <= right) pqLeft.add(arr[left++]);
            }
            else if(!pqLeft.isEmpty() && !pqRight.isEmpty() && pqLeft.peek()[0] > pqRight.peek()[0]) {
                curr = pqRight.poll()[0];
                if(right >= left) pqRight.add(arr[right--]);
            }
            else if(!pqLeft.isEmpty() && !pqRight.isEmpty() && pqLeft.peek()[0] == pqRight.peek()[0]) {
                if(pqLeft.peek()[1] < pqRight.peek()[1]) {
                    curr = pqLeft.poll()[0];
                    if(left <= right) pqLeft.add(arr[left++]);
                }
                else {
                    curr = pqRight.poll()[0];
                    if(right >= left) pqRight.add(arr[right--]);
                }
            }
            else if(pqLeft.isEmpty() && !pqRight.isEmpty()) {
                curr = pqRight.poll()[0];
                if(right >= left) pqRight.add(arr[right--]);
            }
            else if(!pqLeft.isEmpty() && pqRight.isEmpty()) {
                curr = pqLeft.poll()[0];
                if(left <= right) pqLeft.add(arr[left++]);
            }
            ans += curr;
        }
        return ans;
    }
}