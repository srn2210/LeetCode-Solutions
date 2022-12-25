class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] list = new int[queries.length];
        Arrays.sort(nums);
        int[] sum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++) sum[i] = sum[i-1] + nums[i-1];
        for(int i=0; i<queries.length; i++) {
            int t = Arrays.binarySearch(sum, queries[i]);
            list[i] = t < 0 ? -t-2 : t;
        }
        return list;
    }
}