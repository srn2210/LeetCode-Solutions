class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        long sum = 0;
        for(int i:nums) sum += i;
        long curr = 0;
        long ans = INT_MAX;
        int res = 0;
        for(int i=0; i<nums.size(); i++) {
            curr += nums[i];
            long a = (curr/(i+1));
            long b = 0;
            if(i != nums.size()-1) {
                b = (sum-curr)/(nums.size()-i-1);
            }
            long temp = abs(a - b);
            if(temp < ans) {
                ans = temp;
                res = i;
            }
        }
        return res;
    }
};