class Solution {
    public int minimumDeviation(int[] nums) {
        var set = new TreeSet<Long>();
        for(int i : nums) set.add((long)i);
        int ans = (int)(set.last()-set.first());
        /*while(set.first() % 2 != 0) {
            var min = set.first();
            var max = set.last();
            ans = Math.min(ans, (int)(max-min));
            set.remove(min);
            set.add(min*2);
        }
        while(set.last() % 2 == 0) {
            var min = set.first();
            var max = set.last();
            ans = Math.min(ans, (int)(max-min));
            set.remove(max);
            set.add(max/2);
        }
        ans = Math.min(ans, (int)(set.last()-set.first()));
        set = new TreeSet<Long>();
        for(int i : nums) set.add((long)i);*/
        while(set.first() % 2 != 0) {
            var min = set.first();
            var max = set.last();
            ans = Math.min(ans, (int)(max-min));
            set.remove(min);
            set.add(min*2);
        }
        while(set.last() % 2 == 0) {
            var min = set.first();
            var max = set.last();
            ans = Math.min(ans, (int)(max-min));
            set.remove(max);
            set.add(max/2);
        }
        return Math.min(ans, (int)(set.last()-set.first()));
    }
}