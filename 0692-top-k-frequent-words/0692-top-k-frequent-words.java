class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var map = new HashMap<String, Integer>();
        for(var s : words) map.put(s, map.getOrDefault(s, 0)+1);
        var pq = new PriorityQueue<String>((a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : Integer.compare(map.get(a), map.get(b)));
        for(var entry : map.entrySet()) {
            pq.add(entry.getKey());
            if(pq.size() > k) pq.poll();
        }
        var ans = new LinkedList<String>();
        while(!pq.isEmpty()) ans.addFirst(pq.poll());
        return ans;
    }
}