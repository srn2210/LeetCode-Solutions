class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            count += map[sum - k];
            map[sum] = map[sum] + 1;
        }
        return count;
    }
};