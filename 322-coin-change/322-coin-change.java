public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Arrays.sort(coins);
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] set = new boolean[amount + 1];
        
        queue.offer(amount);
        set[amount] = true;
        
        int currLevel = 1;
        int currLevelCount = 1;
        int nextLevelCount = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            currLevelCount --;
            
            for (int coin : coins) {
                int child = curr - coin;
                if (child == 0) {
                    return currLevel;
                } else if (child > 0 && !set[child]) {
                    queue.add(child);
                    set[child] = true;
                    nextLevelCount ++;
                } else if (child < 0) {
                    continue;
                }
            }
            
            if (currLevelCount == 0) {
                currLevel ++;
                currLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        
        return -1;
    }
}