class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        var map = new HashMap<String, Integer>();
        for(var s : words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        var pq = new PriorityQueue<Pair<String, Integer>>((a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : Integer.compare(a.getValue(), b.getValue()));
        for(var entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size() > k) pq.poll();
        }
        var ans = new LinkedList<String>();
        while(!pq.isEmpty()) ans.addFirst(pq.poll().getKey());
        return ans;
    }
}