class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] list = new int[queries.length];
        Arrays.sort(nums);
        for(int i=0; i<queries.length; i++) {
            int sum = 0;
            for(int j=0; j<nums.length; j++) {
                sum += nums[j];
                if(sum > queries[i]) {
                    break;
                }
                list[i] = j+1;
            }
        }
        return list;
    }
}