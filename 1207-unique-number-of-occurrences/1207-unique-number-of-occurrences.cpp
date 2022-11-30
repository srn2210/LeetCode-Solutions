class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int, int> map;
        for(int i : arr) {
            map[i] += 1;
        }
        unordered_set<int> set;
        for(auto i : map) {
            set.insert(i.second);
        }
        return map.size() == set.size();
    }
};