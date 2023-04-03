class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            if(left == right) {
                ans++;
                left++;
                right--;
            }
            else if(people[left] + people[right] > limit) {
                ans++;
                right--;
            }
            else {
                ans++;
                left++;
                right--;
            }
        }
        return ans;
    }
}