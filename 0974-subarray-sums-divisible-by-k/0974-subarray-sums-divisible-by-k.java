class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i] % k + k) % k;
            ans += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return ans;*/
        int[] arr = new int[k];
        int sum = 0;
        int ans = 0;
        for(int num : nums) {
            sum += num;
            arr[(sum % k + k) % k]++;
        }
        //System.out.println(Arrays.toString(arr));
        for(int i=1; i<k; i++) {
            int t = arr[i];
            ans += (t * (t-1)) / 2;
        }
        ans += (arr[0] * (arr[0] + 1)) / 2;
        return ans;
    }
}