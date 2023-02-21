class Solution {
    public int leastInterval(char[] tasks, int n) {
        var map = new int[26];
        for(char ch : tasks) map[ch-'A']++;
        var pq = new PriorityQueue<Character>((a,b) -> map[b-'A']-map[a-'A']);
        for(char ch='A'; ch<='Z'; ch++) if(map[ch-'A'] > 0) pq.add(ch);
        int ans = 0;
        while(!pq.isEmpty()) {
            int t = n+1;
            var remove = new LinkedList<Character>();
            while(t > 0 && !pq.isEmpty()) {
                var p = pq.poll();
                map[p-'A']--;
                remove.add(p);
                ans++;
                t--;
            }
            for(var ch : remove) if(map[ch-'A'] > 0) pq.add(ch);
            if(pq.isEmpty()) break;
            ans += t;
        }
        return ans;
    }
}