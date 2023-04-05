class Solution {
    public int minimizeArrayValue(int[] nums) {
        /*long sum = nums[0];
        int cnt = 1;
        int ans = Integer.MIN_VALUE;
        var list = new ArrayDeque<Pair<Long, Integer>>();
        for(int i=1; i<nums.length; i++) {
            if(nums[i] - nums[i-1] < 0) {
                list.add(new Pair(sum, cnt));
                sum = 0;
                cnt = 0;
            }
            sum += nums[i];
            cnt++;
        }
        if(sum != 0) list.add(new Pair(sum, cnt));
        System.out.println(list);
        while(list.size() >= 2) {
            var top1 = list.pop();
            double t1 = (double)top1.getKey() / top1.getValue();
            var top2 = list.pop();
            double t2 = (double) top2.getKey() / top2.getValue();
            if(t2 > t1) list.add(new Pair(top1.getKey() + top2.getKey(), top1.getValue() + top2.getValue()));
            else {
                ans = Math.max(ans, (int) Math.ceil(t1));
                list.add(top2);
            }
        }
        return Math.max(ans, (int) Math.ceil((double)list.peek().getKey() / list.peek().getValue()));*/
        long sum = 0;
        int n = nums.length;
        double cnt = 1;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            sum += i;
            max = Math.max(max, (int) Math.ceil(sum / cnt++));
        }
        //int avgTotal = (int) Math.ceil(sum / (double)n);
        //int avg = (int) Math.ceil((sum-nums[0]) / (double) (n-1));
        return max;
    }
}