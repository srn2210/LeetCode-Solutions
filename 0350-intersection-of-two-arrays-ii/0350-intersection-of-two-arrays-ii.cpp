class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        int map[1001];
        memset(map, 0, sizeof(map));
        for(int num : nums1) {
            map[num] += 1;
        }
        for(int num : nums2) {
            if(map[num]-- > 0) res.push_back(num);
        }
        return res;
    }
};