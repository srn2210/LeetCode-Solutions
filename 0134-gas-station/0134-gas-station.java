class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // If the total sum of gas - cost is > 0 then there exists a valid answer
        // The answer would be the lowest index with the highest right sum inluding the index itself
        // This is because the lowest index with the highest presum to the right side has the highest chance of completing the journey
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