class Solution {
    int mod = (int)1e9+7;
    public int numberOfWays(String corridor) {
        long ans = 1;
        int streak = 0;
        var q = new LinkedList<String>();
        for(int i=0; i<corridor.length(); i++) {
            if(corridor.charAt(i) == 'S') {
                if(streak != 0) {
                    q.add(String.valueOf(streak+1));
                    streak = 0;
                }
                boolean flag = true;
                for(int j=i+1; j<corridor.length(); j++) {
                    if(corridor.charAt(j) == 'S') {
                        flag = false;
                        i = j;
                        q.add("S");
                        break;
                    }
                }
                if(flag) return 0;
            }
            else {
                streak++;
            }
        }
        if(q.isEmpty()) return 0;
        if(!q.peek().equals("S")) q.poll();
        while(!q.isEmpty()) {
            if(q.peek().equals("S")) q.poll();
            else {
                int t = Integer.parseInt(q.poll());
                ans = ans * t;
                ans %= mod;
            }
        }
        return (int)ans;
    }
}