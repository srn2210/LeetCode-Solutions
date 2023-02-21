class Solution {
    public int leastInterval(char[] tasks, int n) {
        var map = new HashMap<Character, Integer>();
        for(char ch : tasks) map.put(ch, map.getOrDefault(ch, 0) + 1);
        var pq = new PriorityQueue<Character>((a,b) -> map.get(b)-map.get(a));
        for(var entry : map.entrySet()) pq.add(entry.getKey());
        int ans = 0;
        while(!pq.isEmpty()) {
            int t = n+1;
            var remove = new LinkedList<Character>();
            while(t > 0 && !pq.isEmpty()) {
                var p = pq.poll();
                map.put(p, map.get(p)-1);
                remove.add(p);
                ans++;
                t--;
            }
            for(var ch : remove) if(map.get(ch) > 0) pq.add(ch);
            if(pq.isEmpty()) break;
            ans += t;
        }
        return ans;
    }
}