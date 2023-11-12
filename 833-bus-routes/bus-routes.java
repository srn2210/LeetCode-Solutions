class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++) {
            for(int stop : routes[i]) {
                map.computeIfAbsent(stop, a -> new ArrayList<>()).add(i);
            }
        }
        Set<Integer> buses = new HashSet<>();
        Set<Integer> stops = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        // for(int bus : map.getOrDefault(source)) {
        //     buses.add(bus);
        //     for(int stop : routes[bus]) {
        //         if(stops.add(stop)) {
        //             q.add(stop);
        //         }
        //     }
        // }
        q.add(source);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int curr = q.poll();
                if(curr == target) return ans;
                for(int bus : map.getOrDefault(curr, new ArrayList<>())) {
                    if(buses.add(bus)) {
                        for(int stop : routes[bus]) {
                            if(stops.add(stop)) {
                                q.add(stop);
                            }
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}