class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        int[] arr = new int[n];
        var process = new PriorityQueue<long[]>((a,b) -> Long.compare(a[0], b[0]) == 0 ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        var pq = new PriorityQueue<Integer>();
        for(int i=0; i<n; i++) pq.add(i);
        long time = 0;
        int max = 0, idx = 0;
        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            time = Math.max(time, start);
            while(!process.isEmpty() && time >= process.peek()[0]) {
                pq.add((int)process.poll()[1]);
            }
            if(!pq.isEmpty()) {
                int room = pq.poll();
                arr[room]++;
                if(arr[room] > max) {
                    max = arr[room];
                    idx = room;
                }
                else if(arr[room] == max) idx = Math.min(idx, room);
                long[] t = {time + duration, room};
                process.add(t);
            }
            else {
                long[] tt = process.poll();
                time = tt[0];
                pq.add((int)tt[1]);
                int room = pq.poll();
                arr[room]++;
                if(arr[room] > max) {
                    max = arr[room];
                    idx = room;
                }
                else if(arr[room] == max) idx = Math.min(idx, room);
                long[] t = {time + duration, room};
                process.add(t);
            }
        }
        return idx;
    }
}