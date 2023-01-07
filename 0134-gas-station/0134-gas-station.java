class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*int[] arr = new int[gas.length];
        int sum = 0;
        sum = gas[0] - cost[0];
        for(int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1] + gas[i-1] - cost[i-1];
            sum += gas[i] - cost[i];
        }
        if(sum < 0) return -1;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(sum - arr[i] > max) {
                max = sum - arr[i];
                ans = i;
            }
        }
        return ans;*/
        //int[] arr = new int[gas.length];
        int pre = gas[gas.length-1] - cost[cost.length-1];
        int ans = gas.length-1;
        int max = pre;
        for(int i=gas.length-2; i>=0; i--) {
            pre = pre + gas[i] - cost[i];
            if(pre >= max) {
                max = pre;
                ans = i;
            }
        }
        return pre < 0 ? -1 : ans;
    }
}