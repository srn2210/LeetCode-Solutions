class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for(int entry : map.values()) {
            if(entry == 1) return -1;
            else if(entry % 3 == 0) ans += entry / 3;
            else ans += entry / 3 + 1;
        }
        return ans;
    }
}