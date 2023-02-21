class Solution {
    public int leastInterval(char[] tasks, int n) {
        var map = new int[26];
        for(char ch : tasks) map[ch-'A']++;
        var pq = new PriorityQueue<Integer>((a,b) -> map[b]-map[a]);
        for(int i=0; i<26; i++) if(map[i] > 0) pq.add(i);
        int ans = 0;
        while(!pq.isEmpty()) {
            int t = n+1;
            var remove = new ArrayList<Integer>();
            while(t > 0 && !pq.isEmpty()) {
                var p = pq.poll();
                map[p]--;
                if(map[p] != 0) remove.add(p);
                ans++;
                t--;
            }
            for(var ch : remove) pq.add(ch);
            ans += pq.isEmpty() ? 0 : t;
        }
        return ans;
    }
}