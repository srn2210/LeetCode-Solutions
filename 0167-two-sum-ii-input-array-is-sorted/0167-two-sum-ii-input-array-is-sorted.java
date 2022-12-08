class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length-1; i++) {
            int temp = target - numbers[i];
            int ans = Arrays.binarySearch(numbers, i+1, numbers.length, temp);
            if(ans > 0) return new int[]{i+1, ans+1};
        }
        return new int[]{-1,-1};
    }
}