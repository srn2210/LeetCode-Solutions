class Solution {
    int reverse(int num, Map<Integer, Integer> map) {
        int ans = 0;
        int cpy = num;

        while(num > 0) {
            ans = (ans * 10) + num % 10;
            num /= 10;
        }

        int diff = cpy - ans;
        map.put(diff, map.getOrDefault(diff, 0) + 1);

        return ans;
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length, mod = (int)1e9+7;
        long ans = 0;
        int[] rev = new int[n];
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
            rev[i] = reverse(nums[i], map);
        }

        // System.out.println(map);

        // var set = new HashSet<Integer>();

        // for(var entry : map.entrySet()) {
        //     int diff = entry.getKey();
        //     int numDiff = entry.getValue();

        //     int negDiff = -diff;

        //     if(set.contains(negDiff) || diff == 0) continue;

        //     if(map.containsKey(negDiff)) {
        //         long t = numDiff * (long)map.get(negDiff);
        //         t %= mod;
        //         ans += t;
        //         ans %= mod;
        //         set.add(diff);
        //         set.add(negDiff);
        //     }
        // }

        for(var entry : map.entrySet()) {
            int numDiff = entry.getValue();
            if(numDiff <= 1) continue;

            ans += ((long) numDiff * (numDiff-1)) / 2;
            ans %= mod;
        }

        return (int)ans;
    }
}