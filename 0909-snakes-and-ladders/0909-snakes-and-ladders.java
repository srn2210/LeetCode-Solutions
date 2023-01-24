class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] map = new int[n * n + 1];
        int cnt = 1;
        for(int i=n-1; i>=0; i-=2) {
            for(int j=0; j<n; j++) {
                map[cnt++] = board[i][j];
            }
            cnt += n;
        }
        cnt = n + 1;
        for(int i=n-2; i>=0; i-=2) {
            for(int j=n-1; j>=0; j--) {
                map[cnt++] = board[i][j];
            }
            cnt += n;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int x = queue.poll();
                for(int i=1; i<=6; i++) {
                    int t = x + i;
                    if(t > n * n) continue;
                    if(map[t] != -1 && map[t] == n * n) return ans + 1;
                    if(t == n * n) return ans + 1;
                    if(!set.contains(t)) {
                        set.add(t);
                        if(map[t] != -1) queue.add(map[t]);
                        else queue.add(t);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}