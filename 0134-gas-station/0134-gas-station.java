class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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