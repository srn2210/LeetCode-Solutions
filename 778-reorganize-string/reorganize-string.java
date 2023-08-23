class Solution {
    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder res = new StringBuilder();
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[1], a[1]));
        for(int i=0; i<26; i++) {
            if(arr[i] > 0) pq.add(new int[]{i, arr[i]});
        }
        while(!pq.isEmpty()) {
            if(res.length() == 0 || res.charAt(res.length()-1) != (char)('a' + pq.peek()[0])) {
                res.append((char)('a' + pq.peek()[0]));
                var t = pq.poll();
                if(t[1] - 1 > 0) {
                    t[1]--;
                    pq.add(t);
                }
            }
            else {
                if(pq.size() == 1) return "";
                else {
                    var tt = pq.poll();
                    res.append((char)('a' + pq.peek()[0]));
                    var t = pq.poll();
                    if(t[1] - 1 > 0) {
                        t[1]--;
                        pq.add(t);
                    }
                    pq.add(tt);
                }
            }
        }
        return res.toString();
    }
}